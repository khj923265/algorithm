package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecombinationDNA2217 {
    private static String[] DNAs;
    private static String RecombinationDNA;

    public static void main(String[] args) throws IOException {
        /**
         * DNA 조합 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DNAs = new String[N];
        for (int i = 0; i < N; i++) {
            DNAs[i] = br.readLine();
        }


    }

    private static void RecombinationDNA(String DNA1, String DNA2) {
        int minStringLength = Math.min(DNA1.length(), DNA2.length());


    }
}
