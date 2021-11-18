package BaekJoon.practice;

public class Honeycomb2292 {

    public static void main(String[] args) throws Exception {
        int N = read();
        int multiplesOfSix = 6;
        int count = 1;
        int startNum = 2;

        while (N >= startNum) {
            startNum += multiplesOfSix;
            multiplesOfSix += 6;
            ++count;
        }

        System.out.println(count);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
