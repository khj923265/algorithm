package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
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

        // 결과값을 리스트에 넣어서 정렬 후 출력을 했는데
        // 우선순위 큐 라는 걸 보게되어서 사용해봄 이런경우 편리할듯

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        apartments = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] rowBoards = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            apartments[i] = rowBoards;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apartments[i][j] == 1) {
                    apartmentCount = bfs(i, j);
                    priorityQueue.add(apartmentCount);
                }
            }
        }

        sb.append(priorityQueue.size()).append("\n");
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll()).append("\n");
        }
        System.out.println(sb);
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
                int my = y + dy[i];

                if (0 <= mx && 0 <= my && mx < N && my < N && apartments[mx][my] == 1) {
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
