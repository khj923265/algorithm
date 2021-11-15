package BaekJoon.practice;

public class RectangularEscape1085 {

    public static void main(String[] args) throws Exception {
        /**
         *  직사각형 탈출 문제
         */

        // x, y, w - x, h - y 4개중 최솟값?

        int x = read(); /* 현재 x축 */
        int y = read(); /* 현재 y축 */
        int w = read(); /* 직사각형 모서리 x축 */
        int h = read(); /* 직사각형 모서리 y축 */

        int minX = Math.min(x, w - x);
        int minY = Math.min(y, h - y);
        int min = Math.min(minX, minY);

        System.out.println(min);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
