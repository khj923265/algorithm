package BaekJoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Deque10866 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        // _체크 후 있으면 스플릿 후 char(1)로 스위치 없으면 char(0)으로 스위치
        // _이 있고 char(1) = 'u' 일 경우 " "로 다시 스플릿 후 푸쉬하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int firstInput = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        /**
         * 228ms
         */
        while (firstInput --> 0){
            String commend = br.readLine();
            if (commend.contains("_")){
                String[] commends = commend.split("_");
                switch (commend.charAt(1)){
                    // push 일 경우
                    case 'u':
                        String[] Xs = commends[1].split(" ");
                        int X = Integer.parseInt(Xs[1]);
                        if (commends[1].charAt(0) == 'f') {
                            deque.addFirst(X);
                        } else {
                            deque.addLast(X);
                        }
                        break;
                    // pop 일 경우
                    case 'o':
                        if (commends[1].charAt(0) == 'f'){
                            if (deque.isEmpty()) {
                                sb.append("-1").append("\n");
                            } else {
                                sb.append(deque.pollFirst()).append("\n");
                            }
                        }else {
                            if (deque.isEmpty()) {
                                sb.append("-1").append("\n");
                            } else {
                                sb.append(deque.pollLast()).append("\n");
                            }
                        }
                        break;
                }
            }else {
                switch (commend.charAt(0)){
                    // size
                    case 's':
                        sb.append(deque.size()).append("\n");
                        break;
                    // empty
                    case 'e':
                        if (deque.isEmpty()){
                            sb.append("1").append("\n");
                        }else {
                            sb.append("0").append("\n");
                        }
                        break;
                    // front
                    case 'f':
                        if (deque.isEmpty()){
                            sb.append("-1").append("\n");
                        }else {
                            sb.append(deque.getFirst()).append("\n");
                        }
                        break;
                    // back
                    case 'b':
                        if (deque.isEmpty()){
                            sb.append("-1").append("\n");
                        }else {
                            sb.append(deque.getLast()).append("\n");
                        }
                        break;
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
