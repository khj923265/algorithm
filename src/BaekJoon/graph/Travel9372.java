package BaekJoon.graph;

public class Travel9372 {
    private static int N;
    private static int M;
    private static int[][] list;
    private static boolean[] visit;
    private static int count;

    public static void main(String[] args) throws Exception {
        /**
         *  상근이의 여행 문제
         */

        // 같은 종류의 비행기라서 왔다 갔다 하는건 카운트를 안친다

        StringBuilder sb = new StringBuilder();
        int testCase = read();

        while (testCase --> 0) {
            N = read();
            M = read();

            visit = new boolean[N + 1];
            list = new int[N + 1][N + 1];
            count = 0;

            while (M --> 0) {
                int a = read();
                int b = read();
                list[a][b] = 1;
                list[b][a] = 1;
            }

            dfs(1);
            sb.append(count - 1).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int num) {
        if (visit[num]) {
            return;
        }

        visit[num] = true;
        ++count;
        for (int i = 1; i < N + 1; i++) {
            if (list[num][i] == 1) {
                dfs(i);
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
