package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RankFind17616 {
    private static int[][] student;
    private static boolean[] visited;
    private static int lowerLength;
    private static int higherLength;
    private static int N;
    private static int X;

    public static void main(String[] args) throws IOException {
        /**
         * 등수 찾기 문제
         */

        // 플루이드 와샬 방식 상용시 57점

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        int max = N * (N * (N - 1) / 2); //최대값

        student = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                student[i][j] = max;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            student[n1 - 1][n2 - 1] = 1;
        }

        visited = new boolean[N];
        countHigher(X);
        visited = new boolean[N];
        countLower(X);

        //System.out.println((1 + lowerLength) + " " + (N - higherLength));
        System.out.println((higherLength + 1) + " " + (N - lowerLength));
    }

    public static void countHigher(int i) {
        visited[i] = true;

        for (int j = 0; j < N; j++) {
            if (!visited[j] && student[i][j] == 1) {
                higherLength = higherLength + 1;
                countHigher(j);
            }
        }
    }

    public static void countLower(int i) {
        visited[i] = true;

        for (int j = 0; j < N; j++) {
            if (!visited[j] && student[j][i] == 1) {
                lowerLength = lowerLength + 1;
                countLower(j);
            }
        }
    }
}
