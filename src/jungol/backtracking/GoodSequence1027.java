package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodSequence1027 {

    public static void main(String[] args) throws IOException {
        /**
         * 좋은 수열 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        char[] charList = new char[N];

        charList[0] = '1';
        if (N != 1) charList[1] = '2';

        for (int i = 2; i < N; i++) {
            if ('1' == charList[i - 1]) {
                if ('2' == charList[i - 2]) {
                    charList[i] = '3';
                } else {
                    charList[i] = '2';
                }
            } else {
                charList[i] = '1';
            }
        }

        for (char number : charList) {
            sb.append(number);
        }

        System.out.println(sb);
    }
}
