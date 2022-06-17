package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld4949 {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static char[] words;
    private static StringBuilder sb;
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        /**
         * 균형잡힌 세상 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text;
        sb = new StringBuilder();
        stack = new Stack<>();

        while (true) {
            text = br.readLine();
            if (text.equals(".")) {
                System.out.print(sb);
                return;
            }
            words = text.trim().toCharArray();
            stack.clear();

            isValidWord();

        }

    }

    private static void isValidWord() {
        for (char word : words) {
            if (word == '(') {
                stack.push(word);
            }
            if (word == '[') {
                stack.push(word);
            }
            if (word == ')') {
                if (stack.empty()) {
                    sb.append(NO).append("\n");
                    break;
                }
                char bracket = stack.pop();
                if (bracket != '(') {
                    sb.append(NO).append("\n");
                    break;
                }
            }
            if (word == ']') {
                if (stack.empty()) {
                    sb.append(NO).append("\n");
                    break;
                }
                char bracket = stack.pop();
                if (bracket != '[') {
                    sb.append(NO).append("\n");
                    break;
                }
            }
            if (word == '.') {
                // 괄호가 다 닫혔는지 체크
                if (stack.empty()) {
                    sb.append(YES).append("\n");
                    break;
                }
                sb.append(NO).append("\n");
                break;
            }
        }
    }
}
