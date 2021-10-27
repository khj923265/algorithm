package BaekJoon.practice;

public class LeapYear2753 {

    public static void main(String[] args) throws Exception {
        int N = read();

        if ((N % 4 == 0 && N % 100 != 0) || N % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
