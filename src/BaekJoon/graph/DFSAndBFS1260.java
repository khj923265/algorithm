package BaekJoon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DFSAndBFS1260 {

    static int[][] list;
    static int N;
    static boolean[] check;
    static StringBuilder dfsSb;
    static StringBuilder bfsSb;

    public static void main(String[] args) throws Exception {
        /**
         *  DFS 와 BFS 문제
         *  DFS(깊이 우선 탐색), BFS(넓이 우선 탐색)
         */

        // 정점의 개수, 간선의 개수, 시작번호가 주어지고 간선 번호들이 주어지면
        // DFS 와 BFS 를 각각 출력하기.

        // DFS 는 보통 스택 or 재귀로 해결
        // BFS 는 보통 큐로 해결

        N = read();
        int M = read();
        int startNumber = read();
        dfsSb = new StringBuilder();
        bfsSb = new StringBuilder();

        list = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();

            list[u][v] = 1;
            list[v][u] = 1;
        }
        check = new boolean[N + 1];
        dfs(startNumber);
        check = new boolean[N + 1];
        bfs(startNumber);
        System.out.println(dfsSb);
        System.out.println(bfsSb);

    }

    private static void dfs(int x) {
        if (check[x]) {
            return;
        }
        check[x] = true;
        dfsSb.append(x).append(" ");
        for (int i = 1; i < N + 1; i++) {
            if (!check[i] && list[x][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            bfsSb.append(x).append(" ");
            for (int i = 1; i < N + 1; i++) {
                if (!check[i] && list[x][i] == 1) {
                    check[i] = true;
                    queue.add(i);
                }
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
