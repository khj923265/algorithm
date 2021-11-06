package BaekJoon.bruteforce;

public class NAndM2_15650 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static boolean[] visit;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        sb = new StringBuilder();
        arr = new int[M];
        visit = new boolean[N];

        dfs(0);

        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (depth == 0) {
                if (!visit[i]) {
                    visit[i] = true;
                    arr[depth] = i + 1;
                    dfs(depth + 1);
                    visit[i] = false;
                }
            } else {
                if (!visit[i] && arr[depth - 1] < i + 1) {
                    visit[i] = true;
                    arr[depth] = i + 1;
                    dfs(depth + 1);
                    visit[i] = false;
                }
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
