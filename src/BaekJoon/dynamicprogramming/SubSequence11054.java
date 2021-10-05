package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubSequence11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 가장 긴 바이토닉 부분 수열
         */
        // read() 사용하면 더 빠르게 해결가능함

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] increaseDp = new int[N];
        int[] decreaseDp = new int[N];
        int[] sumDp = new int[N];

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

        // 감소하는 수열 dp 저장
        for (int i = N - 1; i >= 0; i--) {
            decreaseDp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && decreaseDp[i] < decreaseDp[j] + 1) {
                    decreaseDp[i] = decreaseDp[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sumDp[i] = increaseDp[i] + decreaseDp[i] - 1;
        }

        System.out.println(Arrays.stream(sumDp).max().getAsInt());
    }
}
