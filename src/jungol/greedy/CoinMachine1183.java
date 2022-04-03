package jungol.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinMachine1183 {

    public static void main(String[] args) throws IOException {
        /**
         * 동전 자판기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int fiveHundredWon = Integer.parseInt(st.nextToken());
        int oneHundredWon = Integer.parseInt(st.nextToken());
        int fiftyWon = Integer.parseInt(st.nextToken());
        int tenWon = Integer.parseInt(st.nextToken());
        int fiveWon = Integer.parseInt(st.nextToken());
        int oneWon = Integer.parseInt(st.nextToken());

        // 가지고 있는 코인의 총 개수
        int numberOfCoins = fiveHundredWon + oneHundredWon + fiftyWon + tenWon + fiveWon + oneWon;
        // 가지고 있는 코인의 총 합
        int money = fiveHundredWon*500 + oneHundredWon*100 + fiftyWon*50 + tenWon*10 + fiveWon*5 + oneWon;
        while (true) {
            if (money == price) {
                System.out.println(numberOfCoins);
                System.out.print(fiveHundredWon + " " + oneHundredWon + " " + fiftyWon + " " + tenWon + " " + fiveWon + " " + oneWon);
                break;
            }
            if (0 < fiveHundredWon && money-500 >= price) {
                money -= 500;
                --fiveHundredWon;
                --numberOfCoins;
                continue;
            }
            if (0 < oneHundredWon && money-100 >= price) {
                money -= 100;
                --oneHundredWon;
                --numberOfCoins;
                continue;
            }
            if (0 < fiftyWon && money-50 >= price) {
                money -= 50;
                --fiftyWon;
                --numberOfCoins;
                continue;
            }
            if (0 < tenWon && money-10 >= price) {
                money -= 10;
                --tenWon;
                --numberOfCoins;
                continue;
            }
            if (0 < fiveWon && money-5 >= price) {
                money -= 5;
                --fiveWon;
                --numberOfCoins;
                continue;
            }
            if (0 < oneWon && money-1 >= price) {
                money -= 1;
                --oneWon;
                --numberOfCoins;
            }
        }
    }
}
