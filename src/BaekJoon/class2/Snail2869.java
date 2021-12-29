package BaekJoon.class2;

public class Snail2869 {

    public static void main(String[] args) throws Exception {
        /**
         * 달팽이는 올라가고 싶다 문제
         */

        // 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다.
        // V까지 올라가는데 걸리는 일수는?

        // 5 1 60
        // 55 까지 4로 14번

        int A = read();
        int B = read();
        int V = read();

        if (A == V) {
            System.out.println(1);
        }  else {
            int a = (V - A)/(A - B);
            if ((V - A)%(A - B) == 0) {
                System.out.println(a + 1);
            } else {
                System.out.println(a + 2);
            }
        }
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
