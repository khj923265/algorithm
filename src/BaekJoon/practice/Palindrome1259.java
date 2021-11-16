package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome1259 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            String number = br.readLine();
            if (number.equals("0")) break;

            StringBuilder reversSb = new StringBuilder();

            reversSb.append(number);
            reversSb.reverse();
            String reversNumber = reversSb.toString();

            if (number.equals(reversNumber)) {
                result.append("yes").append("\n");
            } else {
                result.append("no").append("\n");
            }
        }

        System.out.println(result);

    }
}
