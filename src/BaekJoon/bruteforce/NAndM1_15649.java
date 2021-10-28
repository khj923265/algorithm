package BaekJoon.bruteforce;

public class NAndM1_15649 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        int M = read();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == j) break;
                sb.append(i).append(" ").append(j).append("\n");
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
