package BaekJoon.binaraysearch;

import java.util.Arrays;

public class SetupRouter2110 {
    private static int[] list;
    private static int houseOfNumber;
    private static int routerOfNumber;

    public static void main(String[] args) throws Exception {
        /**
         * 공유기 설치 문제
         */

        houseOfNumber = read();
        routerOfNumber = read();
        list = new int[houseOfNumber];

        for (int i = 0; i < houseOfNumber; i++) {
            list[i] = read();
        }
        Arrays.sort(list);

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int start = 1;
        int end = list[houseOfNumber - 1];
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (routerOfNumber <= canSetupRouterOfNumber(mid)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static int canSetupRouterOfNumber(int distance) {
        int count = 1;
        int lastLocation = list[0];

        for (int x : list) {
            if (lastLocation + distance <= x) {
                lastLocation = x;
                count ++;
            }
        }
        return count;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
