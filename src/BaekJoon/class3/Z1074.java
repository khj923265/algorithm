package BaekJoon.class3;

public class Z1074 {
    /**
     * Z 문제
     * 분할정복 문제
     */

    private static int count = 0;
    public static void main(String[] args) throws Exception {
        int N = read();
        int row = read();
        int col = read();
        int size = (int) Math.pow(2, N);
        findZCount(size, row, col);
        System.out.println(count);
    }

    private static void findZCount(int size, int r, int c) {
        if (size == 1) {
            return;
        }
        int halfSize = size/2;
        
        // 1사분면에 있을 경우
        if (r < halfSize && c < halfSize) {
            findZCount(halfSize, r, c);
            return;
        }
        // 2사분면에 있을 경우
        if (r < halfSize) {
            count = count + (halfSize * halfSize);
            findZCount(halfSize, r, c - halfSize);
            return;
        }
        // 3사분면에 있을 경우
        if (c < halfSize) {
            count = count + (halfSize * halfSize) * 2;
            findZCount(halfSize, r - halfSize, c);
            return;
        }
        // 4사분면에 있을 경우
        count = count + (halfSize * halfSize) * 3;
        findZCount(halfSize, r - halfSize, c - halfSize);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}