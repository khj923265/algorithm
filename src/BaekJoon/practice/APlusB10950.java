package BaekJoon.practice;

public class APlusB10950 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int testCase = read();
        int A;
        int B;

        while (testCase --> 0) {
            A = read();
            B = read();

            sb.append(A + B).append("\n");
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
