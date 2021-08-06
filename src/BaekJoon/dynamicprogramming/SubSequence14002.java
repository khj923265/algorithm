package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSequence14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정답보고 이해함
        // dp[], arr[] 배열 2개를 사용
        // 나중 이분탐색공부시 이분탐색으로도 풀이 가능 ( 시간복잡도가 n^2 에서 n log n  으로 줄어들 수 있음 )
        // 기본적인 LIS 문제

        // 처음엔 단순 카운트로 생각해보고 고쳐보자 생각함
        // arr[] =  10 30 10 50 20 40
        // dp[]  =  1  2  2  3  3  4   - > 여기서 다음으로 진도를 못나가서 정답확인
        // dp[]  =  1  2  1  3  2  3  이런식으로 전값보다 작으면 새롭게 카운트 하는 방법

        // ex) arr[3] = 50 의 값의 dp를 찾는 순서
        // 45번라인 if 문 설명 1. arr[0] = 10 과 비교해서 큰지(더 큰수를 찾는 거니까)
        //                  2. dp[0] + 1 과 비교해서 더 작은지 (dp[] 가 더 작다는건 그전에 계산되어 있던 거니까)
        //                  dp[0] = 1 이고 dp[3] = 0 고로 dp[3]은 일단 2 가 됨 dp[0] + 1 이니까 2
        // arr[1] = 30 또 비교 위에 로직과 같음 dp[3] = 3 이 됨
        // arr[2] = 10 if 1번에서 부터 막혀서 결국 dp[3] = 3

        // ex) arr[5] = 40 의 값의 dp를 찾는 순서
        // arr[0] = 10  과 비교 값도 크고 dp[4] = 0부터 시작이라 dp[4] = 2 가 됨
        // arr[1] = 30 위와 마찬가지라 dp[4] = 3 이 됨
        // arr[2] = 10 값은 더 크지만 dp[2] = 1 + 1 < dp[4] = 3 이기 때문에 카운트가 안됨
        // 여기 부분이 dp를 비교하는 이유 dp[5] 가 더 크다는건 dp[2]는 전에 값들과 비교했을때 작은 값이 있었다는 의미
        // 비교할때 +1 을 해줘서 비교하는 이유는 비교 값은 이미 카운트가 된값이고 i 인 현재값은 아직 카운트가 안된 값이기 떄문

        // 알고리즘의 기본?적인 문제인것 같음 다이나믹프로그랭으로 해결시 시간복잡도가 n^2
        // 이분탐색으로 해결시 n log n 이 가능함
        // 이분탐색 : 반으로 나눠가며 해결하는 방법 보통 이분탐색은 log n 으로 알려져있음

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int max = -1;

        // split 사용보다 Tokenizer 사용이 조금 더 빠르다고 함
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (max < dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}
