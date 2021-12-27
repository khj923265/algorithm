package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result;

        int number = Integer.parseInt(br.readLine());
        if (number == 0) {
            result = 1;
        } else {
            result = factorial(number);
        }
        System.out.println(result);
    }

    private static int factorial(int num) {
        if (num == 1) return 1;

        return num * factorial(num-1);
    }

}
