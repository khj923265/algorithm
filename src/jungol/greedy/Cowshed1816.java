package jungol.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cowshed1816 {

    public static void main(String[] args) throws IOException {
        /**
         * 외양간 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int M = Integer.parseInt(firstLine[0]); // 최대 구매 가능한 판자의 수
        int S = Integer.parseInt(firstLine[1]); // 외양간의 수
        int C = Integer.parseInt(firstLine[2]); // 소가 있는 외양간의 수

        int[] cowshedList = new int[C]; // 소가 있는 외양간 번호 리스트
        List<Integer> betweenList = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            cowshedList[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(cowshedList);

        for (int i = 1; i < C; i++) {
            if (1 < cowshedList[i] - cowshedList[i - 1]) {
                betweenList.add(cowshedList[i] - cowshedList[i - 1] - 1);
            }
        }

        int maxLength = cowshedList[C - 1] - cowshedList[0] + 1;

        betweenList.sort(Collections.reverseOrder());

        for (int betweenNumber : betweenList) {
            if (0 < M - 1) {
                maxLength -= betweenNumber;
                --M;
            } else {
                break;
            }
        }

        System.out.println(maxLength);

    }
}
