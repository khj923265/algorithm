package BaekJoon.binaraysearch;

import java.util.Arrays;

public class CuttingLANCable1654 {
    private static long[] list;
    private static int cableOfNumber;
    private static int necessaryCableOfNumber;

    public static void main(String[] args) throws Exception {
        /**
         * 랜선 자르기 문제
         */

        // 802
        // 743
        // 457
        // 539

        // 457 , 539 , 743 , 802
        // 1,    1,    1,    2  =  5  <  11
        // 2,     2,  , 3,  , 4  = 11 =  11
        // 0 , 802 최대값
        //  401
        //  0 ~ 400  = 200

        cableOfNumber = read();
        necessaryCableOfNumber = read();

        list = new long[cableOfNumber];
        for (int i = 0; i < cableOfNumber; i++) {
            list[i] = read();
        }

        Arrays.sort(list);
        long result = binarySearch();

        System.out.println(result);
    }

    private static long binarySearch() {
        long start = 0;
        long end = list[list.length - 1];
        long mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (necessaryCableOfNumber <= getCutCableOfNumber(mid)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static int getCutCableOfNumber(long length) {
        int count = 0;
        for (long cableLength : list) {
            count += cableLength / length;
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
