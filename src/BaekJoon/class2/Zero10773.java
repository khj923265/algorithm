package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero10773 {

    public static void main(String[] args) throws IOException {
        /**
         * 제로 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int number;
        long total = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            number = Integer.parseInt(br.readLine().trim());
            if (number == 0) {
                stack.pop();
                continue;
            }
            stack.push(number);
        }
        while (!stack.empty()) {
            total = total + stack.pop();
        }
        System.out.println(total);
    }
}
