package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakingTheWallAndMoving2206 {
    private static int[][] boards;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        /**
         * 벽 부수고 이동하기 문제
         */

        // BFS 문제인데 0은 이동가능 1은 벽이라 이동이 불가능하지만 1번만 벽을 부수고 지나갈 수 있음
        // (0,0) 에서 (N,M) 으로 이동하는 최단거리를 구하기 불가능시 -1 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer testCase = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(testCase.nextToken());
        M = Integer.parseInt(testCase.nextToken());

        boards = new int[N][M];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                boards[i][j] = Integer.parseInt(str[j]);
            }
        }

        int result = bfs();

        System.out.println(result);

    }

    private static int bfs() {
        Queue<Board> queue = new LinkedList<>();
        queue.offer(new Board(0, 0, 1, false));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Board board = queue.poll();

            if (board.x == N - 1 && board.y == M - 1) {
                return board.count;
            }

            for (int i = 0; i < 4; i++) {
                int mx = board.x + dx[i];
                int my = board.y + dy[i];

                if (0 <= mx && 0 <= my && mx < N && my < M && !visited[mx][my]) {
                    if (boards[mx][my] == 1 && !board.breaking) {
                        visited[mx][my] = true;
                        queue.offer(new Board(mx, my, board.count + 1, true));
                    } else if (boards[mx][my] == 0) {
                        visited[mx][my] = true;
                        queue.offer(new Board(mx, my, board.count + 1, board.breaking));
                    }
                }
            }
        }

        return -1;
    }

    private static class Board {
        int x;
        int y;
        int count;
        boolean breaking;

        private Board(int x, int y, int count, boolean breaking) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.breaking = breaking;
        }
    }
}
