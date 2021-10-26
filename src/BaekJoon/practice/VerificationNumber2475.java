package BaekJoon.practice;

public class VerificationNumber2475 {

    public static void main(String[] args) throws Exception {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int a = read();
            sum += a*a;
        }
        System.out.println(sum%10);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
