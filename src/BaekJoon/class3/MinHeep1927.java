package BaekJoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeep1927 {

    /**
     * 최소 힙 문제
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int number;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (q.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(q.poll()).append("\n");
                continue;
            }
            q.add(number);
        }
        System.out.println(sb);
    }
}
