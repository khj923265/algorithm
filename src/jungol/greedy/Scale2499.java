package jungol.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Scale2499 {

    public static void main(String[] args) throws IOException {
        /**
         * 저울 문제
         */

        // 누적합 + 1 로 생각하면 쉬움
        // 1 1 2 3 6 7 30
        // 1 1 로 만들 수 있는 최대값 = 2
        // 1 1 2 로 만들 수 있는 최대값 = 4
        // 1 1 2 3 로 만들 수 있는 최대값 = 7 ...
        // 1 1 2 3 6 7 로 만들 수 있는 최대값 = 20 < 30
        // 20 +  1 = 21 (정답)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] weightList = new int[N];

        for (int i = 0; i < N; i++) {
            weightList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weightList);

        int sum = weightList[0];
        if (sum != 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (sum + 1 < weightList[i]) {
                break;
            } else {
                sum += weightList[i];
            }
        }
        System.out.println(sum + 1);

    }
}
