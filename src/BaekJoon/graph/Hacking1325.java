package BaekJoon.graph;

public class Hacking1325 {
    private static int N;
    private static int M;
    private static int count;
    private static int maxCount;
    private static int[][] list;
    private static boolean[] visit;


    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        N = read();
        M = read();

        list = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        maxCount = -1;

        while (M --> 0) {
            int A = read();
            int B = read();

            list[B][A] = 1;
        }

        for (int i = 1; i <= N; i++) {
            count = 0;
            dfs(i);
            if (maxCount < count) {
                sb = new StringBuilder();
                sb.append(i);
                maxCount = count;
            } else if (maxCount == count) {
                sb.append(" ").append(i);
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int startNum) {
        if (visit[startNum]) {
            return;
        }

        visit[startNum] = true;
        for (int i = 1; i <= N; i++) {
            if (list[startNum][i] == 1) {
                dfs(i);
                ++count;
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
