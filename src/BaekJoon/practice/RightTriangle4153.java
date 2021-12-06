package BaekJoon.practice;

public class RightTriangle4153 {

    public static void main(String[] args) throws Exception {
        /**
         * 직각삼각형 문제
         */
        // 두변의 제곱과 나머지 한번의 제곱이 같으면 직각삼각형

        StringBuilder sb = new StringBuilder();

        boolean isDone = true;
        while (isDone) {
            int a = read();
            int b = read();
            int c = read();

            if (a == 0 && b == 0 && c == 0) {
                isDone = false;
                continue;
            }
            if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
