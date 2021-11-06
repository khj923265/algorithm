package BaekJoon.bruteforce;

public class NAndM4_15652 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        arr = new int[M];
        sb = new StringBuilder();

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
                arr[depth] = i + 1;
                dfs(depth + 1);
            } else if (arr[depth - 1] <= i + 1){
                arr[depth] = i + 1;
                dfs(depth + 1);
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
