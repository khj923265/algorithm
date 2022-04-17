package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodSequence1027 {
    private static int N;

    public static void main(String[] args) throws IOException {
        /**
         * 좋은 수열 문제
         */

        // N = 8
        // 1213 1213 일경우 나쁜수열이라 다시 해결

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        backtracking("");

    }

    public static void backtracking(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGoodSequence(str + i)) {
                backtracking(str + i);
            }
        }
    }

    public static boolean isGoodSequence(String str) {
        for (int i = 1; i <= str.length()/2; i++) {
            if (str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i))) {
                return false;
            }
        }
        return true;
    }
}
