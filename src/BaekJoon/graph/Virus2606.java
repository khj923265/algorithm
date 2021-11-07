package BaekJoon.graph;

public class Virus2606 {
    private static int comCount;
    private static int infectionCount;
    private static int[][] list;
    private static boolean[] check;

    public static void main(String[] args) throws Exception {
        /**
         *  바이러스 문제
         */

        comCount = read();
        int testCase = read();

        infectionCount = 0;
        list = new int[comCount + 1][comCount + 1];
        check = new boolean[comCount + 1];

        for (int i = 1; i <= testCase; i++) {
            int x = read();
            int y = read();

            list[x][y] = 1;
            list[y][x] = 1;
        }

        dfs(1);

        System.out.println(infectionCount);


    }

    private static void dfs(int comNumber) {
        if (check[comNumber]) {
            return;
        }

        check[comNumber] = true;
        for (int i = 1; i <= comCount; i++) {
            if (!check[i] && list[comNumber][i] == 1) {
                dfs(i);
                ++infectionCount;
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
}
