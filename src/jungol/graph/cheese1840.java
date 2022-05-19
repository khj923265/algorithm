package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cheese1840 {
    private static int[][] board;
    private static boolean[][] visited;
    private static final int[] dx = { -1, 0, 1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };
    private static int maxXIndex;
    private static int maxYIndex;
    private static boolean isCheese = true;
    private static int count = 0;
    private static int lastCheeseCount = 0;

    public static void main(String[] args) throws IOException {
        /**
         * 치즈 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        maxXIndex = x + 2;
        maxYIndex = y + 2;
        board = new int[x + 2][y + 2];
        visited = new boolean[x + 2][y + 2];

        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= x; j++) {
                board[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        while (isCheese) {
            resetVisited();
            isCheese = false;
            lastCheeseCount = 0;
            checkCheese(0, 0);
            count = count + 1;
        }

        System.out.println(count - 1);
        System.out.println(lastCheeseCount);


    }

    public static void checkCheese(int x, int y) {
        board[x][y] = 0;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if (nextX < 0 || nextY < 0 || maxXIndex <= nextX || maxYIndex <= nextY) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            if (board[nextX][nextY] == 1) {
                isCheese = true;
                visited[nextX][nextY] = true;
                board[nextX][nextY] = 2;
                continue;
            }
            if (board[nextX][nextY] == 2) {
                lastCheeseCount = lastCheeseCount + 1;
            }
            checkCheese(nextX, nextY);
        }
    }

    public static void resetVisited() {
        for (int i = 0; i < maxXIndex; i++) {
            for (int j = 0; j < maxYIndex; j++) {
                visited[i][j] = false;
            }
        }
    }
}
