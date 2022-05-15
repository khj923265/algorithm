package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindArea1457 {
    private static int[][] list;

    public static void main(String[] args) throws IOException {
        /**
         * 영역 구하기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int rectangleCnt = Integer.parseInt(st.nextToken());

        list = new int[x][y];
        List<Rectangle> rectangles = new ArrayList<>();

        for (int i = 0; i < rectangleCnt; i++) {
            String[] coordinates = br.readLine().split(" ");
            rectangles.add(new Rectangle(coordinates));
        }

        for (Rectangle rectangle : rectangles) {

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

        public int getStartX() {
            return startX;
        }

        public void setStartX(int startX) {
            this.startX = startX;
        }

        public int getStartY() {
            return startY;
        }

        public void setStartY(int startY) {
            this.startY = startY;
        }

        public int getEndX() {
            return endX;
        }

        public void setEndX(int endX) {
            this.endX = endX;
        }

        public int getEndY() {
            return endY;
        }

        public void setEndY(int endY) {
            this.endY = endY;
        }
    }
}
