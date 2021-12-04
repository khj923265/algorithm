package BaekJoon.graph;

public class NumberOfIsland4963 {
    private static int W;
    private static int H;
    private static int list[][];
    private static boolean visit[][];
    private static int numberOfIsland;

    public static void main(String[] args) throws Exception {
        /**
         * 섬의 개수 문제
         */

        // 유기농배추문제와 비슷 대각선까지 생각만 하면 되는 문제 같음
        // (i-1,j-1),(i+1,j-1),(i-1,j+1),(i+1,j+1) 4가지 추가하면 될듯?

        StringBuilder sb = new StringBuilder();

        boolean isDone = true;
        while (isDone) {
            W = read();
            H = read();
            list = new int[H][W];
            visit = new boolean[H][W];

            if (W == 0 && H == 0) {
                isDone = false;
                continue;
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    list[i][j] = read();
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (list[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        ++numberOfIsland;
                    }
                }
            }
            sb.append(numberOfIsland).append("\n");
            numberOfIsland = 0;
        }

        System.out.println(sb);


    }

    public static void dfs(int i, int j) {
        if (i < H && j < W) {
            if (!visit[i][j] && list[i][j] == 1) {
                visit[i][j] = true;

                
                dfs(i + 1, j + 1);
                dfs(i,j + 1);
                dfs(i + 1, j);

                if (0 < i && 0 < j) {
                    dfs(i - 1, j - 1);
                }
                if (0 < i) {
                    dfs(i - 1, j);
                    dfs(i - 1, j + 1);
                }
                if (0 < j) {
                    dfs(i, j - 1);
                    dfs(i + 1, j - 1);
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
