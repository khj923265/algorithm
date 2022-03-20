package BaekJoon.greedy;

public class GasStation13305 {
    private static long[] distances;
    private static long[] prices;

    public static void main(String[] args) throws Exception {
        /**
         * 주유소 문제
         */

        // 5 2 4 1
        // 리터당 기름가격, 시작부터 리터당 가격이 현재 가격보다 싼곳을 찾은 곳 까지 기름을 구매

        int N = read();
        distances = new long[N - 1];
        prices = new long[N];

        for (int i = 0; i < N - 1; i++) {
            distances[i] = read();
        }
        for (int i = 0; i < N; i++) {
            prices[i] = read();
        }

        long cheapPrice = prices[0];
        long spentMoney = prices[0] * distances[0];
        for (int i = 1; i < N - 1; i++) {
            if (cheapPrice >= prices[i]) {
                cheapPrice = prices[i];
            }
            spentMoney += cheapPrice * distances[i];
        }

        System.out.println(spentMoney);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
