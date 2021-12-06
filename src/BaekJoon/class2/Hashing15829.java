package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing15829 {
    private static final int thirtyOne = 31;
    private static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        /**
         * hashing 문제
         * 제곱에 %M 해줘야하는데 뭔가 막힘
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;

        int testCase = Integer.parseInt(br.readLine());
        String strings = br.readLine();

        for (int i = 0; i < testCase; i++) {
            char c = strings.charAt(i);
            int stringNumber = c - 96;

            result += stringNumber * pow(thirtyOne, i);

        }
        System.out.println(result%M);
    }

    public static long pow(int a, int b) {
        if (b == 1) return a;
        if (b == 0) return 1;
        long result = 0;
        for (int i = 1; i < b; i++) {
            result += ((long) a * a)%M;
        }
        return result%M;
    }
}
