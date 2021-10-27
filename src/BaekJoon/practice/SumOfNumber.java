package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfNumber {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] numberArr = br.readLine().split("");
        int sum = 0;

        for (String number : numberArr) {
            sum += Integer.parseInt(number);
        }

        System.out.println(sum);

    }

}
