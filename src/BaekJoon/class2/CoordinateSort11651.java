package BaekJoon.class2;

import java.util.Arrays;

public class CoordinateSort11651 {

    public static void main(String[] args) throws Exception {
        /**
         * 좌표 정렬하기 2 문제
         */

        int testCase = read();
        int[][] list = new int[testCase][2];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            list[i][0] = read();
            list[i][1] = read();
        }

        Arrays.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int[] i : list) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
