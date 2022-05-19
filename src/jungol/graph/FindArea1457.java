package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindArea1457 {
    private static boolean[][] board;
    private static final int[] dx = { -1, 0, 1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };
    private static int maxXIndex;
    private static int maxYIndex;
    private static int count;

    public static void main(String[] args) throws IOException {
        /**
         * 영역 구하기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int rectangleCnt = Integer.parseInt(st.nextToken());

        board = new boolean[x][y];
        maxXIndex = x;
        maxYIndex = y;
        List<Rectangle> rectangles = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < rectangleCnt; i++) {
            String[] coordinates = br.readLine().split(" ");
            rectangles.add(new Rectangle(coordinates));
        }

        rectangles.forEach(Rectangle::checked);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!board[i][j]) {
                    count = 0;
                    dfs(i,j);
                    result.add(count);
                }
            }
        }

        result.sort(Integer::compareTo);
        System.out.println(result.size());
        result.forEach(count -> System.out.print(count + " "));

    }

    public static void dfs(int x, int y) {
        board[x][y] = true;

        count = count + 1;

        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if (nextX < 0 || nextY < 0 || maxXIndex <= nextX || maxYIndex <= nextY) {
                continue;
            }
            if (board[nextX][nextY]) {
                continue;
            }
            dfs(nextX, nextY);
        }

    }

    private static class Rectangle{
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Rectangle(String[] coordinates) {
            this.startX = Integer.parseInt(coordinates[0]);
            this.startY = Integer.parseInt(coordinates[1]);
            this.endX = Integer.parseInt(coordinates[2]);
            this.endY = Integer.parseInt(coordinates[3]);
        }

        public void checked() {
            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    board[i][j] = true;
                }
            }
        }
    }
}
