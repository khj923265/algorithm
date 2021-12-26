package BaekJoon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek1697 {
    private static Queue<Integer> queue;
    private static int[] visit;
    private static int brotherLocation;
    private static int currentLocation;

    public static void main(String[] args) throws Exception {
        /**
         * 숨바꼭질 문제
         */

        // hint 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

        queue = new LinkedList<>();
        visit = new int[100_001];

        currentLocation = read();
        brotherLocation = read();

        if (currentLocation == brotherLocation) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    private static void bfs() {
        queue.offer(currentLocation);
        visit[currentLocation] = 1;

        while (!queue.isEmpty()) {
            int location = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = location * 2;
                } else if (i == 1) {
                    next = location + 1;
                } else {
                    next = location - 1;
                }

                if (next == brotherLocation) {
                    System.out.println(visit[location]);
                    return;
                }

                if (0 <= next && next < 100_001 && visit[next] == 0) {
                    queue.offer(next);
                    visit[next] = visit[location] + 1;
                }
            }
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
