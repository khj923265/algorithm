package BaekJoon.practice;

public class TestScore9498 {

    public static void main(String[] args) throws Exception {
        int score = read();

        if (90 <= score && score <= 100) {
            System.out.println("A");
        } else if (80 <= score && score <= 89) {
            System.out.println("B");
        } else if (70 <= score && score <= 79) {
            System.out.println("C");
        } else if (60 <= score && score <= 69) {
            System.out.println("D");
        } else {
            System.out.println("F");
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
