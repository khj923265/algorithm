package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Quadrant14681 {

    public static void main(String[] args) throws Exception {
        /**
         * 사분면 고르기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (0 < x) {
            if (0 < y) {
                System.out.println(1);
            } else {
                System.out.println(4);
            }
        } else {
            if (0 < y) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
