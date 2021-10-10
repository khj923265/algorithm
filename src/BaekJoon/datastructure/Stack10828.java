package BaekJoon.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack10828 {

    public static void main(String[] args) throws IOException {
        // Buffered 쓴 이유는 띄어쓰기 까지 한줄로 읽으려고 사용한건데 잘 모르고 사용했음...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        // 첫번째 입력값(반복문 돌아가는 수)
        int firstInput = Integer.parseInt(br.readLine());

        // 스위치 하다 안돼서 그냥 for문에 if문 돌렸습니다.
        // 첫번째 입력값 만큼 반복
        for(int i = 0; i < firstInput; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
//            lastInput = bufferedReader.readLine();
            // push 1 에서 띄어쓰기를 배열로 나눠서 받음 ex)array[0] = push, array[1] = 1
//            String[] array = lastInput.split(" ");

            //push를 포함시 ( contains = 다른게 있어도 포함만 하면 읽음 )
            switch (st.nextToken()){
                case "push" :stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if (stack.empty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size" : bw.write(stack.size() + "\n");
                    break;
                case "empty" :
                    if (stack.empty()) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                    break;
                case "top" :
                    if (stack.empty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
            }
//            if (lastInput.contains("push")) {
//                stack.push(Integer.parseInt(array[1]));
//            } else if (lastInput.contains("pop")){
//                System.out.println(stack.empty() ? -1 : stack.pop());
//            } else if (lastInput.contains("size")){
//                // 스택의 사이즈 출력
//                System.out.println(stack.size());
//            } else if (lastInput.contains("empty")){
//                // 스택이 비어있는 경우 (true or false 를 반환함)
//                System.out.println(stack.empty() ? 1 : 0);
//            } else if (lastInput.contains("top")){
//                // peek 스택의 가장 꼭대기 값을 반환 해줌
//                System.out.println(stack.empty() ? -1 : stack.peek());
//            }
        }
        bw.flush();
        bw.close();
    }

}
