package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarPrint2440 {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        /**
         * 별 찍기3 문제
         */
        // *****
        // ****
        // ***
        // **
        // *
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        printStar(N);
        System.out.println(sb);

    }

    public static void printStar(int N) {
        if (N == 0) {
            return;
        }
        sb.append("*".repeat(N)).append("\n");
        printStar(N - 1);
    }
}
