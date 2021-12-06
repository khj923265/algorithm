package BaekJoon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MovingKnight7562 {

    public static void main(String[] args) throws Exception {
        /**
         * 나이트의 이동 문제
         */
        //최소 이동 경로를 찾을 때는 DFS를 통해서 수행하면 최소의 경우를 보장할 수 없어 BFS 탐색을 통해 문제를 해결해보자.

        int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
        StringBuilder sb = new StringBuilder();

        int testCase = read();

        while (testCase --> 0) {
            int boardSize = read();
            int startX = read();
            int startY = read();
            int targetX = read();
            int targetY = read();

            int[][] moves = new int[boardSize][boardSize];

            Queue<Knight> queue = new LinkedList<>();
            queue.offer(new Knight(startX, startY));

            while (!queue.isEmpty()) {
                Knight knight = queue.poll();
                int x = knight.x;
                int y = knight.y;

                for (int i = 0; i <8; i++) {
                    int my = y + dy[i];
                    int mx = x + dx[i];

                    if (startX == mx && startY == my) continue;

                    if (0 <= my && my < boardSize && 0 <= mx && mx < boardSize && moves[my][mx] == 0) {
                        moves[my][mx] = moves[y][x] + 1;
                        queue.offer(new Knight(mx, my));
                    }
                }

                if (moves[targetY][targetX] != 0) break;
            }
            sb.append(moves[targetY][targetX]).append("\n");

        }

        System.out.println(sb);

    }

    private static class Knight {
        int x;
        int y;

        public Knight(int x, int y) {
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
