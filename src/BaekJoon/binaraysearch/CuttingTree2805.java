package BaekJoon.binaraysearch;

import java.util.Arrays;

public class CuttingTree2805 {
    private static long necessaryTreeLength;
    private static int[] list;

    public static void main(String[] args) throws Exception {
        /**
         * 나무 자르기 문제
         */

        int treeOfNumber = read();
        necessaryTreeLength = read();
        list = new int[treeOfNumber];

        for (int i = 0; i < treeOfNumber; i++) {
            list[i] = read();
        }
        Arrays.sort(list);

        System.out.println(binarySearch());
    }

    private static int binarySearch() {
        int start = 1;
        int end = list[list.length - 1];
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (necessaryTreeLength <= getCutTreeLength(mid)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }
    // 20 15 10 17 나무높이
    // 5  0  0  2  = 7

    // 10 5  0  7 = 22
    //  스타트 = 10 엔드 20
    // 15
    private static long getCutTreeLength(int length) {
        long result = 0;
        for (int treeLength : list) {
            int cuttingTreeLength = treeLength - length;
            if (0 < cuttingTreeLength) {
                result += cuttingTreeLength;
            }
        }
        return result;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
