package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrinterQueue1966 {
    private static StringTokenizer st;
    private static PriorityQueue<Handout> priorityQueue;

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

            priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < numberOfHandout; j++) {
                priorityQueue.offer(new Handout(Integer.parseInt(st.nextToken()), j));
            }

            for (int j = 1; j < numberOfHandout + 1; j++) {
                if (!priorityQueue.isEmpty()) {
                    if (priorityQueue.poll().getIndex() == numberOfIndex) {
                        sb.append(j).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

class Handout implements Comparable<Handout>{
    int priority;
    int index;

    public Handout(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }

    public int getPriority() {
        return priority;
    }
    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Handout handout) {

        if (this.priority > handout.getPriority())
            return 1;
        else if (this.priority < handout.getPriority())
            return -1;
        else {
            if (this.index < handout.getIndex()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
