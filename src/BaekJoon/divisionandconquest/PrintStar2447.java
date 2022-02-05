package BaekJoon.divisionandconquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStar2447 {
    private static int N;
    private static int k;
    private static char[][] stars;

    public static void main(String[] args) throws IOException {
        /**
         * 별 찍기10 문제
         */
        //TODO 해결 해야함!!!

        // N = 3 의 배수, 9일경우 3의 패턴을 가운데(공백) 빼고 반복
        // ***
        // * *
        // ***
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        k = searchMultipleOfThree(N);
        stars = new char[N][N];


    }

    private static int searchMultipleOfThree(int number) {
        if (number < 2) {
            return 0;
        }
        return 1 + searchMultipleOfThree(number/3);
    }

    private static void makeStar(int x, int y, boolean isEmpty) {

    }

}
