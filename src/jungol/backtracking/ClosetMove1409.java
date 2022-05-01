package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClosetMove1409 {
    private static int N;
    private static int lastIndex;
    private static int[] openClosetNumbers;
    private static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /**
         * 벽장문의 이동 문제
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int firstDoor = Integer.parseInt(st.nextToken());
        int secondDoor = Integer.parseInt(st.nextToken());

        int availableClosetCount = Integer.parseInt(br.readLine());
        openClosetNumbers = new int[availableClosetCount];
        lastIndex = openClosetNumbers.length - 1;

        for (int i = 0; i < availableClosetCount; i++) {
            openClosetNumbers[i] = Integer.parseInt(br.readLine());
        }

        dfs(firstDoor, secondDoor, 0, 0);

        System.out.println(minCount);


    }

    private static void dfs(int firstDoor, int secondDoor, int index, int count) {
        if (index == lastIndex) {
            int nearDoor = Math.min(Math.abs(openClosetNumbers[index] - firstDoor), Math.abs(openClosetNumbers[index] - secondDoor));
            minCount = Math.min(minCount, count + nearDoor);
            return;
        }

        int firstCount = Math.abs(openClosetNumbers[index] - firstDoor);
        int secondCount = Math.abs(openClosetNumbers[index] - secondDoor);

        dfs(openClosetNumbers[index], secondDoor, index + 1, count + firstCount);
        dfs(firstDoor, openClosetNumbers[index], index + 1, count + secondCount);

    }
}
