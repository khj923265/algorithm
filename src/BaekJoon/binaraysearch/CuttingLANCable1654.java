package BaekJoon.binaraysearch;

import java.util.Arrays;

public class CuttingLANCable1654 {
    private static int[] list;

    public static void main(String[] args) throws Exception {
        /**
         * 랜선 자르기 문제
         */

        int cableOfNumber = read();
        int necessaryCableOfNumber = read();

        list = new int[cableOfNumber];
        for (int i = 0; i < cableOfNumber; i++) {
            list[i] = read();
        }

        Arrays.sort(list);

    }

    private static int binarySearch() {
        int start = 0;
        int end = list[list.length - 1];
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            // 여기서부터 로직 수행하면 될듯?

            if (list[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
