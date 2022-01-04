package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiplication2588 {

    public static void main(String[] args) throws IOException {
        /**
         * 곱셈 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] mod = new int[3];

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());


        for (int i = 0; i < 3; i++) {
            mod[i] = B%10;
            B /= 10;
        }
        int z = A * mod[0];
        int x = (A * mod[1]);
        int c = (A * mod[2]);

        sb.append(z).append("\n");
        sb.append(x).append("\n");
        sb.append(c).append("\n");
        sb.append(z + (x * 10) + (c * 100));

        System.out.println(sb);
    }
}
