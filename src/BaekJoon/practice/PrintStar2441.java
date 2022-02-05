package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStar2441 {
    private static StringBuilder sb;
    private static int N;

    public static void main(String[] args) throws IOException {
        /**
         * 별 찍기4 문제
         */
        // *****
        //  ****
        //   ***
        //    **
        //     *
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        printStar(N);
        System.out.println(sb);

    }

    public static void printStar(int i) {
        if (i == 0) {
            return;
        }
        sb.append(" ".repeat(N - i)).append("*".repeat(i)).append("\n");
        printStar(i - 1);
    }
}
