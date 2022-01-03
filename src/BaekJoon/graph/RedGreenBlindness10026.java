package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreenBlindness10026 {
    private static char[][] grids;
    private static boolean[][] visited;
    private static int N;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        /**
         * 적록색약 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        grids = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            grids[i] = str.toCharArray();
        }

        visited = new boolean[N + 1][N + 1];
        int redNumber = findColor('R');
        int greenNumber = findColor('G');
        int blueNumber = findColor('B');

        int normalCount = redNumber + greenNumber + blueNumber;

        visited = new boolean[N + 1][N + 1];

        int redAndGreenNumber = findColorBlindness();

        int blindnessCount = redAndGreenNumber + blueNumber;

        sb.append(normalCount).append(" ").append(blindnessCount);

        System.out.println(sb);
    }

    private static int findColor(char color) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grids[i][j] == color && !visited[i][j]) {
                    bfs(i, j, color);
                    ++count;
                }
            }
        }
        return count;
    }

    private static void bfs(int x, int y, char color) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = location.x + dx[i];
                int my = location.y + dy[i];

                if (0 <= mx && 0 <= my && mx < N && my < N && grids[mx][my] == color && !visited[mx][my]) {
                    visited[mx][my] = true;
                    queue.offer(new Location(mx, my));
                }
            }
        }
    }

    private static int findColorBlindness() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((grids[i][j] == 'R' || grids[i][j] == 'G') && !visited[i][j]) {
                    bfsBlindness(i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private static void bfsBlindness(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = location.x + dx[i];
                int my = location.y + dy[i];

                if (0 <= mx && 0 <= my && mx < N && my < N && (grids[mx][my] == 'R' || grids[mx][my] == 'G') && !visited[mx][my]) {
                    visited[mx][my] = true;
                    queue.offer(new Location(mx, my));
                }
            }
        }
    }

    private static class Location {
        int x;
        int y;

        private Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
