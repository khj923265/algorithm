package BaekJoon.class2;

import java.util.LinkedList;
import java.util.Queue;

public class CardTwo2164 {
    private static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {
        /**
         * 카드1 문제
         */

        queue = new LinkedList<>();

        int N = read();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        shuffleCard();

        System.out.println(queue.poll());
    }

    private static void shuffleCard() {
        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
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
