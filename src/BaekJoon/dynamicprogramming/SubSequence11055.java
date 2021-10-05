package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSequence11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 가장 큰 증가 부분 수열
         * 증가하는 부분수열의 합이 가장 큰 값을 고르시오
         */

        // 10
        // 1 100 2 50 60 3 5 6 7 8
        // 정답 : 113

        //TODO 증가 부분수열만 복사 해놨음 수정해서 해결해야함
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] increaseDp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가하는 수열 dp 저장
        for(int i = 0; i < N; i++) {
            increaseDp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && increaseDp[i] < increaseDp[j] + 1) {
                    increaseDp[i] = increaseDp[j] + 1;
                }
            }
        }
    }

}
