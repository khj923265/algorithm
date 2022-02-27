package BaekJoon.divisionandconquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuadTree1992 {

    private static int[][] blackImages;

    public static void main(String[] args) throws IOException {
        /**
         * 쿼드트리 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        blackImages = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                blackImages[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }


}
