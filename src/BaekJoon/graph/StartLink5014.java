package BaekJoon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class StartLink5014 {
    private static int topFloor;
    private static int currentFloor;
    private static int targetFloor;
    private static int upButton;
    private static int downButton;
    private static boolean[] visitCheck;

    public static void main(String[] args) throws Exception {
        /**
         * 스타트링크 문제
         */

        // 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
        // 보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)
        // 강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오. 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.

        // 첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.

        topFloor = read();
        currentFloor = read();
        targetFloor = read();
        upButton = read();
        downButton = read();
        visitCheck = new boolean[topFloor + 1];

        int[] floorInfo = new int[2];
        floorInfo[0] = currentFloor;

        int resultCount = bfs(floorInfo);

        if (resultCount == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(resultCount);
        }
    }

    private static int bfs(int[] floorInfo) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(floorInfo);

        while (!queue.isEmpty()) {
            int[] floorInfos = queue.poll();
            if (visitCheck[floorInfos[0]]){
                continue;
            }
            visitCheck[floorInfos[0]] = true;

            if (floorInfos[0] == targetFloor) {
                return floorInfos[1];
            }

            int upFloor = floorInfos[0] + upButton;
            int downFloor = floorInfos[0] - downButton;

            if (upFloor <= topFloor) {
                int[] upFloors = new int[2];
                upFloors[0] = upFloor;
                upFloors[1] = floorInfos[1] + 1;
                queue.offer(upFloors);
            }
            if (0 < downFloor) {
                int[] downFloors = new int[2];
                downFloors[0] = downFloor;
                downFloors[1] = floorInfos[1] + 1;
                queue.offer(downFloors);
            }
        }

        return -1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
