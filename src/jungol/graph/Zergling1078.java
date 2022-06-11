package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Zergling1078 {
    private static int[][] zerglings;
    private static boolean[][] visited;
    private static final int[] dx = { -1, 0, 1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };
    private static int ROW;
    private static int COL;
    private static int X;
    private static int Y;
    private static int survivedZerglingCnt;
    private static int timeOfInfection;

    public static void main(String[] args) throws IOException {
        /**
         * 저글링 방사능 오염 문제
         */

        // 입력값 저장
        saveInputValue();

        // 저글링 감염 시작 bfs
        startInfection();

        // 마지막으로 감염돼서 죽은 저글링의 시간과 살아남은 저글링의 숫자 저장
        findInfectedZerglingAndSurvivedZergling();
        System.out.println(timeOfInfection);
        System.out.println(survivedZerglingCnt);

    }

    private static void saveInputValue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        COL = Integer.parseInt(st.nextToken());
        ROW = Integer.parseInt(st.nextToken());

        zerglings = new int[ROW][COL];
        visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < COL; j++) {
                zerglings[i][j] = Integer.parseInt(strings[j]);
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;
    }

    private static void findInfectedZerglingAndSurvivedZergling() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                // 맵 상에서 방문한적이 없고 0 이 아니라면 저글링은 있지만 감염이 안된것으로 +1
                if (zerglings[i][j] != 0 && !visited[i][j]) {
                    survivedZerglingCnt = survivedZerglingCnt + 1;
                }
                // 방문=감염 감염된 저글링중 가장 마지막에 된 저글링의 카운트값 저장
                if (visited[i][j]) {
                    timeOfInfection = Math.max(zerglings[i][j], timeOfInfection);
                }
            }
        }
        // 가장 마지막에 감염된 저글링이 3초뒤 죽기 떄문에 + 2
        timeOfInfection = timeOfInfection + 2;
    }

    public static void startInfection() {
        Queue<Zergling> queue = new LinkedList<>();
        queue.offer(new Zergling(X, Y, 1));
        visited[Y][X] = true;

        while (!queue.isEmpty()) {
            Zergling zergling = queue.poll();

            for (int i = 0; i < 4; i++) {
                int col = dx[i] + zergling.x;
                int row = dy[i] + zergling.y;

                if (row < 0 || col < 0 || ROW <= row || COL <= col) continue;
                if (zerglings[row][col] == 0 || visited[row][col]) continue;

                // queue.offer 부분 디버그로 확인시 쉽게 설명 가능
                visited[row][col] = true;
                zerglings[row][col] = zergling.count + 1;
                queue.offer(new Zergling(col, row, zerglings[row][col]));
            }
        }
    }

    public static class Zergling {
        int x;
        int y;
        int count;

        public Zergling(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
