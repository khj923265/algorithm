package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland2589 {
    private static int N;
    private static int M;
    private static char[][] boards;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        /**
         * 보물섬 문제
         */

        // W = 바다, L = 육지 육지로만 이동이 가능하다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = read();
        M = read();

        boards = new char[N][M];
        int minMovementCount = 1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boards[i] = str.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (boards[i][j] == 'L') {
                    int count = bfs(i,j);
                    if (minMovementCount < count) {
                        minMovementCount = count;
                    }
                }
            }
        }

        System.out.println(minMovementCount);

    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visitCheck = new boolean[N + 1][M + 1];
        int[] location = new int[3];
        int count = 0;
        location[0] = x;
        location[1] = y;
        queue.offer(location);
        visitCheck[location[0]][location[1]] = true;

        while (!queue.isEmpty()) {
            int[] locationInfo = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = locationInfo[0] + dx[i];
                int my = locationInfo[1] + dy[i];

                if (0 <= mx && 0 <= my && mx < N && my < M && boards[mx][my] == 'L' && !visitCheck[mx][my]) {
                    visitCheck[mx][my] = true;
                    int[] moveInfo = new int[3];
                    moveInfo[0] = mx;
                    moveInfo[1] = my;
                    moveInfo[2] = locationInfo[2] + 1;
                    count = moveInfo[2];
                    queue.offer(moveInfo);
                }
            }
        }
        return count;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
