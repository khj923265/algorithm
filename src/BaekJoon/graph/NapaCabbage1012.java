package BaekJoon.graph;

public class NapaCabbage1012 {
    private static int M;
    private static int N;
    private static int K;
    private static int earthwormNumber;
    private static int[][] list;
    private static boolean[][] check;

    public static void main(String[] args) throws Exception {
        /**
         *  유기농 배추 문제
         *  DFS 와 BFS 문제
         */

        // 처음엔 오른쪽이랑 아래만 탐색하면 되는거 아닌가 했는데
        // 0 1 1 0
        // 1 1 1 1
        // 이런식일 경우 list[1][0] 에 있는 값을 다시탐색하기때문에 카운트가 추가되어서 문제가 생김
        // 그래서 위, 아래, 좌, 우 전부 탐색해줘야함

        int t = read();
        StringBuilder sb = new StringBuilder();

        while (t--> 0) {
            M = read();
            N = read();
            K = read();

            list = new int[N][M];
            check = new boolean[N][M];
            earthwormNumber = 0;

            for (int i = 0; i < K; i++) {
                int x = read();
                int y = read();

                list[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!check[i][j] && list[i][j] == 1) {
                        dfs(i , j);
                        ++earthwormNumber;
                    }
                }
            }
            sb.append(earthwormNumber).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n, int m) {
        if (n < N && m < M) {
            if (!check[n][m] && list[n][m] == 1) {
                check[n][m] = true;
                dfs(n,m + 1);
                dfs(n + 1, m);
                if (0 < n) {
                    dfs(n - 1, m);
                }
                if (0 < m) {
                    dfs(n, m - 1);
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
