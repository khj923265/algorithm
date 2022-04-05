package jungol.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Delivery2641 {

    static class Delivery implements Comparable<Delivery> {
        int startNum;
        int endNum;
        int capacity;

        public Delivery(int startNum, int endNum, int capacity) {
            this.startNum = startNum;
            this.endNum = endNum;
            this.capacity = capacity;
        }

        @Override
        public int compareTo(Delivery o) {
            if (endNum == o.endNum) {
                return startNum - o.startNum;
            }
            return endNum - o.endNum;
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 택배 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sts = br.readLine().split(" ");
        int N = Integer.parseInt(sts[0]); // 마을의 개수
        int C = Integer.parseInt(sts[1]); // 트럭의 용량
        int M = Integer.parseInt(br.readLine()); // 보내는 박스의 정보개수

        Delivery[] deliveryList = new Delivery[M];
        int[] capacityList = new int[N - 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            deliveryList[i] = new Delivery(startNum, endNum, capacity);
        }

        Arrays.sort(deliveryList);

        int result = 0;

        for (Delivery delivery : deliveryList) {
            int startIndex = delivery.startNum - 1;
            int endIndex = delivery.endNum - 1;
            int capacity = delivery.capacity;
            int capacityToLoad = 0;

            for (int i = startIndex; i < endIndex; i++) {
                capacityToLoad = Math.max(capacityToLoad, capacityList[i]);
            }

            if (capacityToLoad == C) continue;

            if (C - capacityToLoad < capacity) {
                for (int i = startIndex; i < endIndex; i++) {
                    capacityList[i] += C - capacityToLoad;
                }
                result += C - capacityToLoad;
            } else {
                for (int i = startIndex; i < endIndex; i++) {
                    capacityList[i] += capacity;
                }
                result += capacity;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
