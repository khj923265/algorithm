package BaekJoon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SafeArea2468 {
    private static int N;
    private static int[][] areas;
    private static boolean[][] isFlooded;
    private static int maxHeight;
    private static int numberOfSafeArea;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        /**
         * 안전 영역 문제
         */

        N = read();
        areas = new int[N][N];
        numberOfSafeArea = 1;
        maxHeight = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int number = read();
                areas[i][j] = number;
                if (maxHeight < number) maxHeight = number;
            }
        }

        for (int height = 1; height < maxHeight; height++) {
            isFlooded = new boolean[N + 1][N + 1];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isFlooded[i][j] && height < areas[i][j]) {
                        bfs(i, j, height);
                        count++;
                    }
                }
            }
            if (numberOfSafeArea < count) numberOfSafeArea = count;
        }

        System.out.println(numberOfSafeArea);

    }

    private static void bfs(int x, int y, int height) {
        Queue<Area> queue = new LinkedList<>();
        queue.offer(new Area(x, y));

        isFlooded[x][y] = true;

        while (!queue.isEmpty()) {
            Area area = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = area.x + dx[i];
                int my = area.y + dy[i];

                if (0 <= mx && 0 <= my && mx < N && my < N && !isFlooded[mx][my] && height < areas[mx][my]) {
                    queue.offer(new Area(mx, my));
                    isFlooded[mx][my] = true;
                }

            }
        }
    }

    private static class Area {
        int x;
        int y;

        private Area(int x, int y) {
            this.x = x;
            this.y = y;
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
