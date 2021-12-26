package BaekJoon.graph;

public class DistanceBetweenNodes1240 {
    private static int[][] list;
    private static int[][] distances;
    private static boolean[] visit;
    private static int targetNode;
    private static int N;
    private static int distanceResult;

    public static void main(String[] args) throws Exception {
        /**
         * 노드사이의 거리 문제
         */

        N = read();
        int M = read();

        list = new int[N][N];
        distances = new int[N][N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N - 1; i++) {
            int firstNode = read() - 1;
            int secondNode = read() - 1 ;
            int distance = read();

            list[firstNode][secondNode] = 1;
            list[secondNode][firstNode] = 1;
            distances[firstNode][secondNode] = distance;
            distances[secondNode][firstNode] = distance;
        }

        for (int i = 0; i < M; i++) {
            int startNode = read() - 1;
            targetNode = read() - 1;
            visit = new boolean[N];
            distanceResult = 0;
            dfs(startNode, distanceResult);
            sb.append(distanceResult).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int num, int distance) {
        if (visit[num]) return;

        if (num == targetNode) {
            distanceResult = distance;
            return;
        }
        visit[num] = true;
        for (int i = 0; i < N; i++) {
            if (!visit[i] && list[num][i] == 1) {
                dfs(i, distances[num][i] + distance);
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
