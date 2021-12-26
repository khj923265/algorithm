package BaekJoon.graph;

public class Tree1068 {
    private static int N;
    private static int count;
    private static int[][] list;
    private static boolean[] visit;

    public static void main(String[] args) throws Exception {
        /**
         * 트리 문제
         */

        N = read();
        list = new int[N][N];
        visit = new boolean[N];
        int root = 0;
        count = 0;

        for (int i = 0; i < N; i++) {
            int parentsNumber = read();

            if (parentsNumber != -1) {
                list[parentsNumber][i] = 1;
            } else {
                root = i;
            }
        }

        int deletedNodeNumber = read();
        dfs(deletedNodeNumber);
        count = 0;

        dfs(root);

//        for (int i = 0; i < N; i++) {
//            dfs(i);
//        }

        System.out.println(count);
    }

    private static void dfs(int num) {
        if (visit[num]) return;

        visit[num] = true;
        boolean lastNodeCheck = true;
        for (int i = 0; i < N; i++) {
            if (!visit[i] && list[num][i] == 1) {
                dfs(i);
                lastNodeCheck = false;
            }
        }
        if (lastNodeCheck) count++;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
