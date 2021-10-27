package BaekJoon.practice;

public class AlarmClock2884 {

    public static void main(String[] args) throws Exception {
        int H = read();
        int M = read();

        if (M < 45) {
            if (H == 0) {
                M += 15;
                H = 23;
            } else {
                M += 15;
                H -= 1;
            }
        } else {
            M -= 45;
        }

        System.out.println(H + " " + M);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
