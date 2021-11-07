package BaekJoon.practice;

public class NumberLessThanX10871 {

    public static void main(String[] args) throws Exception {
        int N = read();
        int X = read();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int value = read();
            if (value < X) {
                sb.append(value).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }

}
