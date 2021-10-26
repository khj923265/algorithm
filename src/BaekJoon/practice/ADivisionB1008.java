package BaekJoon.practice;

public class ADivisionB1008 {

    public static void main(String[] args) throws Exception {
        double A = read();
        double B = read();

        System.out.println(A/B);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
