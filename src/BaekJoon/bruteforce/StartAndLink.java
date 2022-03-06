package BaekJoon.bruteforce;

public class StartAndLink {
    private static int N;
    private static int[][] pointList;
    private static int result;
    private static boolean[] visit;

    public static void main(String[] args) throws Exception {
        /**
         * 스타트와 링크 문제
         */

        N = read();
        pointList = new int[N][N];
        result = Integer.MAX_VALUE;
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pointList[i][j] = read();
            }
        }

        DFS(0, 0);

        System.out.println(result);

    }

    private static void DFS(int index, int count) {
        if (count == N/2) {
            diffCheck();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                DFS(i + 1, count + 1);
                visit[i] = false;
            }
        }

    }

    private static void diffCheck() {
        int aTeamScore = 0;
        int bTeamScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    aTeamScore += pointList[i][j] + pointList[j][i];
                }
                if (!visit[i] && !visit[j]){
                    bTeamScore += pointList[i][j] + pointList[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(aTeamScore - bTeamScore));

        if (result == 0) {
            System.out.println(0);
            System.exit(0);
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
