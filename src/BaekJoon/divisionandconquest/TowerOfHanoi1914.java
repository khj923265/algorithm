package BaekJoon.divisionandconquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TowerOfHanoi1914 {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        /**
         * 하노이 탑 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        if (N <= 20) {
            int moveCount = (int)Math.pow(2, N) - 1;
            sb.append(moveCount).append("\n");
            moveRoundBoard(N, 1, 2, 3);
        } else {
            BigInteger bigInteger = new BigInteger("2");
            bigInteger = bigInteger.pow(N).subtract(new BigInteger("1"));
            sb.append(bigInteger).append("\n");
        }
        System.out.println(sb);
    }

    private static void moveRoundBoard(int num, int from, int by, int to) {
        if (num == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            moveRoundBoard(num - 1, from, to, by);
            sb.append(from).append(" ").append(to).append("\n");
            moveRoundBoard(num - 1, by, from, to);
        }
    }
}
