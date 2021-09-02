package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] priceList = new int[1001][4];
        int[] dp = new int[N + 1];


        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            priceList[i][1] = Integer.parseInt(st.nextToken());
            priceList[i][2] = Integer.parseInt(st.nextToken());
            priceList[i][3] = Integer.parseInt(st.nextToken());
        }

        


    }
}
