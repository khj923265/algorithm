package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OXQuiz8958 {

    public static void main(String[] args) throws IOException {
        /**
         *  OX 퀴즈 문제
         *  OOXXOOXO 이런 입력이 주어지면 O가 연속될때마다 1이 증가한다
         *  1 + 2 + 0 + 0 + 1 + 2 + 0 + 1 = 7 이런식
         *  합계점수를 출력하기.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int sum;
        int count;

        while (testCase --> 0) {
            String[] OXArr = br.readLine().split("");
            sum = 0;
            count = 0;
            if ("O".equals(OXArr[0])) {
                ++sum;
                ++count;
            }
            for (int i = 1; i < OXArr.length; i++) {
                if ("O".equals(OXArr[i])) {
                    if ("O".equals(OXArr[i - 1])) {
                        count += 1;
                        sum += count;
                    } else {
                        ++sum;
                        count = 1;
                    }
                } else {
                    count = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
