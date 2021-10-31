package BaekJoon.bruteforce;

public class NAndM1_15649 {

    private static int M;
    private static int N;
    private static int[] arr;
    private static boolean[] visit;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        /**
         *  N 과 M (1) 문제
         *  1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 출력하기.
         */

        // 백트래킹 유형 문제
        // 트리형태의 노드들을 깊이우선탐색(dfs)하며 노드의 유망성을 판단하고,
        // 유망하지 않다면 가지치기(풀이시간단축)하고 부모노들로 돌아가서 다시 탐색하는 방식

        // ex) 4 2
        //     1 2, 1 3, 1 4, 2 1, 2 3 ...

        N = read();
        M = read();

        arr = new int[M];
        visit = new boolean[N];
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
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
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
