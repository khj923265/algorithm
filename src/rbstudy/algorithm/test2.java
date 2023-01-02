package rbstudy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test2 {

    public static void main(String[] args ) throws IOException {
        // 아래에 1,2,3 입력이 되었을때 Pair 체크를 하시오.
        String test1 = "{[()]}";
        String test2 = "{[(]}";
        String test3 = "{";

        // 임의 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("임의로 입력해주세요 >>> : ");
        String inputLine = br.readLine();

// ---------------출력------------------------------------------
        System.out.println(TF(test1));
        System.out.println(TF(test2));
        System.out.println(TF(test3));

        System.out.println("임의로 입력한 값의 Pair는 >>> : "+TF(inputLine));

    }

    public static boolean TF(String str) {
        char[] chars = str.toCharArray();
        if (halfCheck(chars)) return false;

        Stack<Character> stack = new Stack<>();
        int halfStrSize = chars.length/2;
        int strSize = chars.length;
        for (int i = 0; i < halfStrSize; i++) {
            stack.push(chars[i]);
        }
        for (int i = halfStrSize; i < strSize; i++) {
            if (!stack.pop().equals(switchBracket(chars[i]))) {
                return false;
            }
        }

        return true;
    }

    public static char switchBracket(char bracket) {
        // 귀찮ㅠ
        if (bracket == '[') return ']';
        if (bracket == ']') return '[';
        if (bracket == '{') return '}';
        if (bracket == '}') return '{';
        if (bracket == '(') return ')';
        if (bracket == ')') return '(';
        return 'f';
    }

    private static boolean halfCheck(char[] a) {
        return a.length % 2 != 0;
    }
}
