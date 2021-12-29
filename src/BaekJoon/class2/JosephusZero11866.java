package BaekJoon.class2;

import java.util.LinkedList;
import java.util.Queue;

public class JosephusZero11866 {
    private static Queue<Integer> queue;
    private static StringBuilder sb;
    private static int N;
    private static int K;

    public static void main(String[] args) throws Exception {
        queue = new LinkedList<>();
        sb = new StringBuilder();
        N = read();
        K = read();

        for (int i = K; i <= N; i++) {
            queue.offer(i);
        }
        for (int i = 1; i < K; i++) {
            queue.offer(i);
        }

        Josephus();

        System.out.println(sb);

    }

    private static void Josephus() {
        sb.append("<");
        while (queue.size() > 1) {
            sb.append(queue.poll()).append(", ");

            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
        }
        sb.append(queue.poll()).append(">");
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
