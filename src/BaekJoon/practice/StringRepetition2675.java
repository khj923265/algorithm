package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRepetition2675 {

    public static void main(String[] args) throws IOException {
        /**
         *  문자열 반복 문제
         *  테스트케이스 수가 주어지고,
         *  3 ABC 가 입력됐을 때 AAABBBCCC 형식으로 출력하기.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            String[] readLine = br.readLine().split(" ");
            int R = Integer.parseInt(readLine[0]);
            String[] stringArr = readLine[1].split("");

            for (String s : stringArr) {
                for (int j = 0; j < R; j++) {
                    sb.append(s);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
