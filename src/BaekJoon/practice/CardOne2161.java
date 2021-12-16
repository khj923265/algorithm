package BaekJoon.practice;

import java.util.LinkedList;
import java.util.Queue;

public class CardOne2161 {
    private static Queue<Integer> queue;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        /**
         * 카드1 문제
         */

        queue = new LinkedList<>();
        sb = new StringBuilder();

        int N = read();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        shuffleCard();

        System.out.println(sb);
    }

    private static void shuffleCard() {
        while (queue.size() != 1) {
            sb.append(queue.poll()).append("\n");
            queue.offer(queue.poll());
        }
        sb.append(queue.poll()).append("\n");
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
}
