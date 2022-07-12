package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MineCraft18111 {
    private static int ROW;
    private static int COL;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        /**
         * 마인크래프트 문제
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        int inventory = Integer.parseInt(st.nextToken());

        board = new int[ROW][COL];
        int minFloor = 256;
        int maxFloor = 0;
        for (int i = 0; i < ROW; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < COL; j++) {
                int blockFloor = Integer.parseInt(strings[j]);
                board[i][j] = blockFloor;
                if (blockFloor < minFloor) {
                    minFloor = blockFloor;
                }
                if (maxFloor < blockFloor) {
                    maxFloor = blockFloor;
                }
            }
        }

        int time = Integer.MAX_VALUE;
        int floor = 0;

        for (int i = minFloor; i <= maxFloor; i++) {
            int usedTime = flattenBlock(i, inventory);
            if (usedTime < time) {
                time = usedTime;
                floor = i;
            }
            if (usedTime == time) {
                floor = Math.max(floor, i);
            }
        }

        // 땅이 평평한지 확인
        // 최소 높이부터 최대 높이까지 평평하게 하는데 걸리는 시간 구하기
        System.out.println(time + " " + floor);

    }

    public static int flattenBlock(int targetFloor, int inventory) {
        int time = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                int currentFloor = board[i][j];
                int usedTime = getUsedTime(targetFloor, currentFloor);
                inventory = inventory - getDifference(targetFloor, currentFloor);
                time = time + usedTime;
            }
        }
        if (inventory < 0) {
            return Integer.MAX_VALUE;
        }
        return time;
    }

    // 숫자 두개 비교해서 작으면 차이만큼 *2 크면 *1
    public static int getUsedTime(int targetFloor, int currentFloor) {
        if (targetFloor < currentFloor) {
            return (currentFloor - targetFloor) * 2;
        }
        if (currentFloor < targetFloor) {
            return targetFloor - currentFloor;
        }
        return 0;
    }

    public static int getDifference(int targetFloor, int currentFloor) {
        return targetFloor - currentFloor;
    }
}