package BaekJoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue10845 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>(); // Queue 생성
        int lastData = 0; // back 에서 사용할 마지막 값
        // 첫번째 입력값
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            // 명령어 입력
            String commend = br.readLine();

            /**
             * 196ms
             */
            if (commend.contains("push")) {
                // 공백으로 문자를 잘라서 push 뒤에 값을 큐에 저장
                String[] commends = commend.split(" ");
                lastData = Integer.parseInt(commends[1]);
                queue.offer(lastData);
            } else if (commend.equals("pop")) {
                // 큐에 값이 있으면 poll 없으면 -1 출력
                sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
            } else if (commend.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (commend.equals("empty")) {
                sb.append(queue.isEmpty() ? "1" : "0").append("\n");
            } else if (commend.equals("front")) {
                sb.append(queue.isEmpty() ? "-1" : queue.peek()).append("\n");
            } else if (commend.equals("back")) {
                sb.append(queue.isEmpty() ? "-1" : lastData).append("\n");
            }

            /**
             * 192ms
             */
//            if (commend.equals("pop")) {
//                sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
//            } else {
//                char a = commend.charAt(0);
//                switch (a) {
//                    case 'p':
//                        // 공백으로 문자를 잘라서 push 뒤에 값을 큐에 저장
//                        String[] commends = commend.split(" ");
//                        lastData = Integer.parseInt(commends[1]);
//                        queue.offer(lastData);
//                        break;
//                    case 's':
//                        sb.append(queue.size()).append("\n");
//                        break;
//                    case 'e':
//                        sb.append(queue.isEmpty() ? "1" : "0").append("\n");
//                        break;
//                    case 'f':
//                        sb.append(queue.isEmpty() ? "-1" : queue.peek()).append("\n");
//                        break;
//                    case 'b':
//                        sb.append(queue.isEmpty() ? "-1" : lastData).append("\n");
//                        break;
//                }
//            }
        }
        System.out.println(sb);
        br.close();
    }
}
