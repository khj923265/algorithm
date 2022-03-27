package jungol.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoplaitFactory2194 {

    public static void main(String[] args) throws IOException {
        /**
         * 요플레 공장 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 운영해야하는 N 주
        int S = Integer.parseInt(firstLine[1]); // 1주의 우유의 리터당 보관비용
        long minMilkPrice = Integer.MAX_VALUE; // 현재 리터당 우유 최소가격
        long minMilkWeek = 1; // 현재 리터당 우유가격 기준 몇주차인지
        long resultPrice = 0; // 결과값

        for (int i = 0; i < N; i++) {
            String[] weekLine = br.readLine().split(" ");
            long C = Integer.parseInt(weekLine[0]);
            long Y = Integer.parseInt(weekLine[1]);

            if (C - (S * minMilkWeek) < minMilkPrice) {
                minMilkPrice = C;
                minMilkWeek = 1;
                resultPrice += C * Y;
            } else {
                resultPrice += minMilkPrice * Y + (S * minMilkWeek * Y);
                ++minMilkWeek;
            }
        }

        System.out.println(resultPrice);


    }
}
