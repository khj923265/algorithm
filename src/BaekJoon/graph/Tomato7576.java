package BaekJoon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Tomato7576 {
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static int N;
    private static int M;
    private static int[][] baxList;
    private static int numberOfDays;
    private static Queue<Tomato> queue;


    public static void main(String[] args) throws Exception {
        /**
         * 토마토 문제
         */

        M = read();
        N = read();
        baxList = new int[N][M];
        numberOfDays = 0;
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                baxList[i][j] = read();
                if (baxList[i][j] == 1) queue.offer(new Tomato(i, j, 1));
            }
        }

        bfs();

        if (isZeroCheck()) return;

        System.out.println(numberOfDays - 1);

    }

    private static boolean isZeroCheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (baxList[i][j] == 0) {
                    System.out.println(-1);
                    return true;
                }
            }
        }
        return false;
    }

    private static void bfs () {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + tomato.x;
                int y = dy[i] + tomato.y;
                if (0 <= x && 0 <= y && x < N && y < M && baxList[x][y] == 0) {
                    baxList[x][y] = tomato.days;
                    queue.offer(new Tomato(x,y,tomato.days + 1));
                }
            }
            numberOfDays = tomato.days;
        }
    }

    private static class Tomato {
        int x;
        int y;
        int days;
        private Tomato (int x,int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
