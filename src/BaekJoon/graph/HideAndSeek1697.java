package BaekJoon.graph;

import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek1697 {
    private static Queue<Integer> queue;
    private static int brotherLocation;
    private static int currentLocation;
    private static int count;

    public static void main(String[] args) throws Exception {
        /**
         * 숨바꼭질 문제
         */

        // hint 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

        // 1. 현재위치*2 가 동생위치보다 2이상 크다면 -1
        // 2. 현재위치*2 가 동생위치보다 2이상 작다면 *2
        // 3. +1

        // 4 17 일 경우 16일때 +1이 아닌 -1이 실행되는 문제가 있음

        // 접근 잘못함 bfs 로 해결해야하는것 같은데?

        queue = new LinkedList<>();
        count = 0;

        currentLocation = read();
        brotherLocation = read();

        while (brotherLocation != currentLocation) {
            if (brotherLocation + 1 < currentLocation * 2) {
                currentLocation -= 1;
                count++;
            } else if (currentLocation * 2 <= brotherLocation + 1 || currentLocation * 2 <= brotherLocation - 1) {
                currentLocation *= 2;
                count++;
            } else {
                currentLocation++;
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs() {
        queue.offer(0);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
