package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TallOrder2462 {

    public static void main(String[] args) throws IOException {
        /**
         * 키 순서 문제
         */

        // 플로이드 와샬 알고리즘 참고

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings;
        strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int max = n * (n * (n - 1) / 2); //최대값

        int[][] student = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                student[i][j] = max;
            }
        }

        for(int i = 0; i < m; i++) {
            strings = br.readLine().split(" ");
            int n1 = Integer.parseInt(strings[0]);
            int n2 = Integer.parseInt(strings[1]);
            student[n1 - 1][n2 - 1] = 1;
        }

        // 플로이드 와샬 공식
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(student[i][j] > student[i][k] + student[k][j]) {
                        student[i][j] = student[i][k] + student[k][j];
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                // 정방향 역방향 이 max 값보다 작으면 연결이 되어있다는 의미니까 count++
                if(student[i][j] < max || student[j][i] < max) count++;
            }
            // count 값이 n - 1 값이면 본인정점을 제외하고 모두 연결이 되어있다는 의미라 순서를 정확히 알 수 있음
            if(count == n - 1) result++;
        }

        System.out.println(result);
    }
}
