package BaekJoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Josephus1158 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        // queue 에 N 만큼 추가
        // k-1만큼 pop하고 푸쉬, k번째에서 pop
        // queue 가 빌때까지반복
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        String commend = br.readLine();
        String[] commends = commend.split(" ");
        Queue<Integer> queue = new LinkedList<>(); // queue 생성
        int N = Integer.parseInt(commends[0]);
        int K = Integer.parseInt(commends[1]);

        /**
         * 588ms
         */
        for (int i = 1; i <= N; i++){
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            for (int j = 1;j < K;j++){
                queue.offer(queue.poll());
            }
            if (queue.size() == 1){
                sb.append(queue.poll()).append(">");
            }else {
                sb.append(queue.poll()).append(", ");
            }
        }

        System.out.println(sb);
        br.close();
    }

}
