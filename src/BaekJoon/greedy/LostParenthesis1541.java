package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LostParenthesis1541 {

    public static void main(String[] args) throws IOException {
        /**
         * 잃어버린 괄호 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings1 = br.readLine().split("-");
        List<Integer> numberList = new ArrayList<>();
        int result = 0;

        for (String str1 : strings1) {
            String[] strings2 = str1.split("\\+");
            int number = 0;
            for (String str2 : strings2) {
                number += Integer.parseInt(str2);
            }
            numberList.add(number);
        }

        result = numberList.get(0);

        for (int i = 1; i < numberList.size(); i++) {
            result -= numberList.get(i);
        }

        System.out.println(result);
    }
}
