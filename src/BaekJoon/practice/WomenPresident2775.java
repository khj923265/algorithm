package BaekJoon.practice;

public class WomenPresident2775 {

    public static void main(String[] args) throws Exception {
        /**
         * 부녀회장이 될테야 문제
         * k(층수), n(호수)
         */
        // 1 4 10 20 35 (2)
        // 1 3 6 10 15 (1)
        // 1 2 3 4 5
        // ?  왜틀리는지 모르겠음

        StringBuilder sb = new StringBuilder();
        int[][] apartment = new int[14][14];
        apartment[0] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int testCase = read();

        while (testCase --> 0) {
            int k = read();
            int n = read();
            int result = 0;

            for (int i = 1; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l <= j; l++) {
                        apartment[i][j] += apartment[i - 1][l];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                result += apartment[k - 1][i];
            }
            sb.append(result).append("\n");
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
