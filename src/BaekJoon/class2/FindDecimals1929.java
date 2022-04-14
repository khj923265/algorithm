package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindDecimals1929 {
    private static boolean[] isDecimals;
    private static int startNumber;
    private static int endNumber;

    public static void main(String[] args) throws IOException {
        /**
         * 소수 구하기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        startNumber = Integer.parseInt(st.nextToken());
        endNumber = Integer.parseInt(st.nextToken());
        isDecimals = new boolean[endNumber + 1];

        for (int i = 2; i <= endNumber/2 + 1; i++) {
            if (!isDecimals[i]) {
                deleteUnDecimals(i);
            }
        }

        for (int i = startNumber; i <= endNumber; i++) {
            if (!isDecimals[i] && i != 1) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void deleteUnDecimals(int number) {
        for (int i = 2; i * number <= endNumber; i++) {
            if (number * i <= endNumber) {
                isDecimals[number * i] = true;
            }
        }
    }
}
