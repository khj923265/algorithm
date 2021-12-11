package BaekJoon.graph;

public class ConnectedComponent11724 {
    private static int N;
    private static int M;
    private static int[][] numberList;
    private static boolean[] visitCheck;

    public static void main(String[] args) throws Exception {
        /**
         * 연결요소의 개수 문제
         */

        // 연결요소의 개수를 찾는 문제
        // dfs로 반복하면서 노드가 끊어졌을 때 마다 카운트를 해주면 그게 연결요소의 개수

        N = read();
        M = read();
        numberList = new int[N][N];
        visitCheck = new boolean[N];
        int ComponentCount = 0;

        while (M --> 0) {
            int u = read() - 1;
            int y = read() - 1;

            numberList[u][y] = 1;
            numberList[y][u] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (!visitCheck[i]) {
                dfs(i);
                ComponentCount++;
            }
        }
        System.out.println(ComponentCount);
    }

    private static void dfs(int n) {
        if (visitCheck[n]) return;

        visitCheck[n] = true;
        for (int i = 0; i < N; i++) {
            if (numberList[n][i] == 1) {
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
