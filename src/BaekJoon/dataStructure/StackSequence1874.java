package BaekJoon.dataStructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();   // 스택 생성

        int firstInput = Integer.parseInt(br.readLine()); // 첫번째 입력값
        int start = 0;

        while (firstInput --> 0){
            int value = Integer.parseInt(br.readLine());

            if (value > start){
                for (int i = start + 1; i <= value; i++){
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;
            }else if (stack.peek() != value){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }

}