package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Constant2908 {

    public static void main(String[] args) throws IOException {
        /**
         * 상수 문제
         * 734 923 일 경우 뒤집어서 큰 수를 출력하기.
         * 437 329 로 뒤집어서 비교
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stringNumberArr = br.readLine().split(" ");

        int a = Integer.parseInt(new StringBuilder(stringNumberArr[0]).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(stringNumberArr[1]).reverse().toString());

        System.out.println(a > b ? a : b);
    }
}
