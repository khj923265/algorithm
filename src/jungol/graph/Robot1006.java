package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Robot1006 {
    private static int N; // 세로길이
    private static int M; // 가로길이
    private static int[][] track;
    private static int[][][] visited;
    private static Coordinate startCoordinate;
    private static Coordinate endCoordinate;
    private static int[] dx = { 1, -1, 0, 0 }; // 0:동 1:서 2:남 3:북
    private static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        /**
         * 로봇 문제
         */

        insertInputValue();

        // 4방향으로 1~3칸까지 유효성확인 후 방문한적이 없으면 큐에 저장
        // 현재 방향기준으로 이동할 방향으로 몇번 움직여야하는지 계산하는 함수 생성

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(startCoordinate);
        int result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            if (coordinate.x == endCoordinate.x && coordinate.y == endCoordinate.y) {
                int directionCount = getDirectionCount(coordinate.direction, endCoordinate.direction);
                result = Math.min(result, coordinate.count + directionCount);
            }
            int row = coordinate.x;
            int col = coordinate.y;

            for (int i = 0; i < 4; i++) {
                int r = row;
                int c = col;

//                if (r < 0 || c < 0 || N <= r || M <= c) continue;
//                if (track[r][c] == 1) continue;
                // 0:동(x+1) 1:서(x-1) 2:남(y+1) 3:북(y-1)
                // bfs 여도 방향때문에 최소가 보장이 안됨
                // 그래서 방문에 방향까지 추가해서 방향이 같을경우 count 값 비교해서
                // 최소로 count 할수 있는 값으로 변경
                for (int j = 1; j <= 3; j++) {
                    if (i == 0) {
                        c = col + j;
                        if (M <= c || track[r][c] == 1) break;
                        int directionCount = getDirectionCount(coordinate.direction, i) + coordinate.count + 1;
                        if (visited[r][c][0] != 0 && visited[r][c][0] <= directionCount) continue;
                        visited[r][c][0] = directionCount;
                        queue.offer(new Coordinate(r, c, i, directionCount));
                    }
                    if (i == 1) {
                        c = col - j;
                        if (c < 0 || track[r][c] == 1) break;
                        int directionCount = getDirectionCount(coordinate.direction, i) + coordinate.count + 1;
                        if (visited[r][c][1] != 0 && visited[r][c][1] <= directionCount) continue;
                        visited[r][c][1] = directionCount;
                        queue.offer(new Coordinate(r, c, i, directionCount));
                    }
                    if (i == 2) {
                        r = row + j;
                        if (N <= r || track[r][c] == 1) break;
                        int directionCount = getDirectionCount(coordinate.direction, i) + coordinate.count + 1;
                        if (visited[r][c][2] != 0 && visited[r][c][2] <= directionCount) continue;
                        visited[r][c][2] = directionCount;
                        queue.offer(new Coordinate(r, c, i, directionCount));
                    }
                    if (i == 3) {
                        r = row - j;
                        if (r < 0 || track[r][c] == 1) break;
                        int directionCount = getDirectionCount(coordinate.direction, i) + coordinate.count + 1;
                        if (visited[r][c][3] != 0 && visited[r][c][3] <= directionCount) continue;
                        visited[r][c][3] = directionCount;
                        queue.offer(new Coordinate(r, c, i, directionCount));
                    }
                }
            }

        }
        return result;
    }

    private static void insertInputValue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        track = new int[N][M];
        visited = new int[N][M][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                track[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int x;
        int y;
        int coordinate;
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;
        coordinate = Integer.parseInt(st.nextToken()) - 1;
        startCoordinate = new Coordinate(x, y, coordinate, 0);
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;
        coordinate = Integer.parseInt(st.nextToken()) - 1;
        endCoordinate = new Coordinate(x, y, coordinate, 0);
    }

    public static int getDirectionCount(int a, int b) {
        if (a == b) {
            return 0;
        }
        if (a == 0) {
            if (b == 1) {
                return 2;
            }
            return 1;
        }
        if (a == 1) {
            if (b == 0) {
                return 2;
            }
            return 1;
        }
        if (a == 2) {
            if (b == 3) {
                return 2;
            }
            return 1;
        }
        if (a == 3) {
            if (b == 2) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static class Coordinate {
        int x;
        int y;
        int direction;
        int count;

        public Coordinate(int x, int y, int direction, int count) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.count = count;
        }
    }
}
