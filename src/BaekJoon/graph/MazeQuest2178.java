package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class MazeQuest2178 {
    private static int[][] boards;
    private static boolean[][] visitCheck;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static int N;
    private static int M;

    public static void main(String[] args) throws Exception {
        /**
         * 미로탐색 문제
         */

        //BFS 로 해결

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = read();
        M = read();

        boards = new int[N][M];
        visitCheck = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            int[] rowBoards = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            boards[i] = rowBoards;
        }

        findMinDistCount();

        System.out.println(boards[N - 1][M - 1]);

    }

    private static void findMinDistCount () {
        Queue<Board> queue = new LinkedList<>();
        queue.offer(new Board(0, 0));

        while (!queue.isEmpty()) {
            Board board = queue.poll();
            int row = board.row;
            int col = board.col;

            for (int i = 0; i < 4; i++) {
                int r = dx[i] + row;
                int c = dy[i] + col;

                if (r < 0 || c < 0 || N <= r || M <= c) continue;
                if (boards[r][c] == 0 || visitCheck[r][c]) continue;

                boards[r][c] = boards[row][col] + 1;
                queue.offer(new Board(r, c));
                visitCheck[r][c] = true;
            }
        }
    }

    private static class Board {
        int row, col;

        public Board (int row, int col) {
            this.row = row;
            this.col = col;
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
