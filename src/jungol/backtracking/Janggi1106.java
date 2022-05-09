package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Janggi1106 {

    public static void main(String[] args) throws IOException {
        /**
         * 장기 문제
         */

        int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int targetX = Integer.parseInt(st.nextToken()) - 1;
        int targetY = Integer.parseInt(st.nextToken()) - 1;

        int[][] moves = new int[N][M];

        Queue<Knight> queue = new LinkedList<>();
        queue.offer(new Knight(startX, startY));

        while (!queue.isEmpty()) {
            Knight knight = queue.poll();
            int x = knight.x;
            int y = knight.y;

            for (int i = 0; i <8; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (startX == mx && startY == my) continue;

                if (0 <= my && my < M && 0 <= mx && mx < N && moves[mx][my] == 0) {
                    moves[mx][my] = moves[x][y] + 1;
                    queue.offer(new Knight(mx, my));
                }
            }

            if (moves[targetX][targetY] != 0) break;
        }



        System.out.println(moves[targetX][targetY]);
    }


    private static class Knight {
        int x;
        int y;

        public Knight(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
