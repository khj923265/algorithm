package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistics2108 {

    public static void main(String[] args) throws IOException {
        /**
         * 통계학 문제
         */

        // 산술평균 : N개의 수들의 합을 N으로 나눈 값
        // 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        // 최빈값 : N개의 수들 중 가장 많이 나타나는 값
        // 범위 : N개의 수들 중 최댓값과 최솟값의 차이

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int previousNumber = 0;
        int sameNumberCount = 1;
        int maxCount = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double total = 0;
        int[] list = new int[N];
        List<Integer> list1 = new ArrayList<>();

        int mode = 0; // 최빈값

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine().trim());
            total = total + number;
            list[i] = number;
            if (max < number) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        Arrays.sort(list);

        for (int i : list) {
            if (previousNumber == i) {
                sameNumberCount = sameNumberCount + 1;
            } else {
                maxCount = Math.max(maxCount, sameNumberCount);
                sameNumberCount = 1;
            }
            previousNumber = i;
        }

        int test = 0;
        int count = 1;
        for (int i : list) {
            if (test == i) {
                count = count +1 ;
                if (count == maxCount) {
                    list1.add(i);
                }
                continue;
            }
            count = 1;
            test = i;
        }
        if (N == 1) {
            mode = list[0];
        } else {
            if (list1.size() == 0) {
                mode = list[1];
            } else if (list1.size() == 1) {
                mode = list1.get(0);
            } else {
                mode = list1.get(1);
            }
        }

        System.out.println(Math.round(total / N));
        System.out.println(list[N/2]);
        System.out.println(mode);
        System.out.println(max - min);
    }
}
