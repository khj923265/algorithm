package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EscapeFromFire1082 {
    private static int ROW;
    private static int COL;
    private static char[][] map;
    private static Queue<Coordinate> queue;
    private static final int[] dx = { -1, 0, 1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        /**
         * 화염에서 탈출
         */
        // . = 빈칸, * = 불, X = 바위, D = 집, S = 시작위치

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        map = new char[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == 'S') {
                    queue.offer(new Coordinate(j, i, 0, 'S'));
                }
            }
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == '*') {
                    queue.offer(new Coordinate(j, i, 0, '*'));
                }
            }
        }

        int result = bfs();
        if (result == 0) {
            System.out.println("impossible");
            return;
        }
        System.out.println(result);
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int col = dx[i] + coordinate.x;
                int row = dy[i] + coordinate.y;

                if (row < 0 || col < 0 || ROW <= row || COL <= col) continue;
                if (coordinate.type == 'S' && map[coordinate.y][coordinate.x] == 'S') {
                    if (map[row][col] == 'D') {
                        return coordinate.count + 1;
                    }
                    if (map[row][col] == '.') {
                        map[row][col] = 'S';
                        queue.offer(new Coordinate(col, row, coordinate.count + 1, 'S'));
                    }
                }
                if (coordinate.type == '*') {
                    if (map[row][col] == '.' || map[row][col] == 'S') {
                        map[row][col] = '*';
                        queue.offer(new Coordinate(col, row, coordinate.count + 1, '*'));
                    }
                }
            }
        }
        return 0;
    }

    public static class Coordinate {
        int x;
        int y;
        int count;
        char type;

        public Coordinate(int x, int y, int count, char type) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.type = type;
        }
    }
}
