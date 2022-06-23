package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue1966 {
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        /**
         * 프린터 큐 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int numberOfHandout = Integer.parseInt(st.nextToken()); // 프린트물의 개수
            int numberOfIndex = Integer.parseInt(st.nextToken()); // 찾고자 하는 프린트물의 순서

            Queue<Handout> queue = new LinkedList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < numberOfHandout; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Handout(priority, j));
                linkedList.add(priority);
            }
            linkedList.sort(Collections.reverseOrder());
            int count = 0;
            while (true) {
                Handout handout = queue.poll();
                if (handout.priority == linkedList.get(0)) {
                    count = count + 1;
                    linkedList.remove(0);
                    if (handout.index == numberOfIndex) {
                        sb.append(count).append("\n");
                        break;
                    }
                    queue.offer(handout);
                    continue;
                }
                queue.offer(handout);
            }
        }
        System.out.println(sb);
    }
}

class Handout {
    int priority;
    int index;

    public Handout(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}
