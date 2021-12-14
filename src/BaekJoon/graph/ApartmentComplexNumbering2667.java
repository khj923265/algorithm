package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class ApartmentComplexNumbering2667 {
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static int[][] apartments;
    private static int N;
    private static int apartmentCount;

    public static void main(String[] args) throws IOException {
        /**
         * 단지번호붙이기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        apartments = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] rowBoards = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            apartments[i] = rowBoards;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                apartmentCount = bfs(i, j);
                if (0 < apartmentCount) {
                    list.add(apartmentCount);
                }
            }
        }

        System.out.println(list.size());
        for (int a : list) {
            System.out.println(a);
        }



    }

    private static int bfs (int row, int col) {
        Queue<Apartment> queue = new LinkedList<>();
        queue.offer(new Apartment(row, col));
        int count = 0;

        while (!queue.isEmpty()) {
            Apartment apartment = queue.poll();
            int x = apartment.x;
            int y = apartment.y;

            if (apartments[x][y] == 1) {
                apartments[x][y] = 0;
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = x + dy[i];

                if (0 < mx && 0 < my && mx < N && my < N && apartments[mx][my] == 1) {
                    apartments[mx][my] = 0;
                    count++;
                    queue.offer(new Apartment(mx, my));
                }
            }
        }
        return count;
    }

    private static class Apartment {
        int x;
        int y;

        private Apartment (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
