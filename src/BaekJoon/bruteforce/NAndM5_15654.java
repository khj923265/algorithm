package BaekJoon.bruteforce;

import java.util.Arrays;

public class NAndM5_15654 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] arr2;
    private static boolean[] visit;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        /**
         *  N 과 M (5) 문제
         */

        N = read();
        M = read();

        for (int i = 0; i < N; i++) {
            arr2[i] = read();
        }
        Arrays.sort(arr2);

        arr = new int[M];
        visit = new boolean[N];
        sb = new StringBuilder();
        arr2 = new int[N];

        dfs(0);

        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = arr2[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
