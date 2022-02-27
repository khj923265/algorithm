package BaekJoon.divisionandconquest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrintStar2447 {
    private static int k;

    public static void main(String[] args) throws IOException {
        /**
         * 별 찍기10 문제
         */

        // N = 3 의 배수, 9일경우 3의 패턴을 가운데(공백) 빼고 반복
        // ***
        // * *
        // ***
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        //k = searchMultipleOfThree(N);
        String[][] stars = new String[n][n];

        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars[0].length; j++) {
                stars[i][j] = " ";
            }
        }

        makeStar(stars, 0, 0, n);

        for (String[] strings : stars) {
            for (String string : strings) {
                bw.write(string + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }


    private static int searchMultipleOfThree(int number) {
        if (number < 3) {
            return 0;
        }
        return 1 + searchMultipleOfThree(number/3);
    }

    private static void makeStar(String[][] stars, int x, int y, int N) {
        if (N == 1) {
            stars[x][y] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    makeStar(stars, x + i * (N / 3), y + j * (N / 3), N / 3);
                }
            }
        }

    }

}
