package BaekJoon.divisionandconquest;

public class MakingConfetti2630 {
    private static int[][] list;
    private static int[] colorCounts;

    public static void main(String[] args) throws Exception {
        /**
         *  색종이 만들기 문제
         */
        int N = read();
        list = new int[N][N];
        colorCounts = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                list[i][j] = read();
            }
        }

        cutConfetti(0,0,N - 1,N - 1);
        System.out.println(colorCounts[0]);
        System.out.println(colorCounts[1]);

    }

    private static void cutConfetti(int startX, int startY, int endX, int endY) {
        int color = list[startX][startY];
        boolean isCheck = true;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (list[i][j] != color) {
                    isCheck = false;
                    break;
                }
            }
        }
        if (isCheck) {
            ++colorCounts[color];
        } else {
            cutConfetti(startX, startY, (startX+endX)/2, (startY+endY)/2);
            cutConfetti((startX+endX)/2 + 1, startY, endX, (startY+endY)/2);
            cutConfetti(startX, (startY+endY)/2 + 1, (startX+endX)/2, endY);
            cutConfetti((startX+endX)/2 + 1, (startY+endY)/2 + 1, endX, endY);
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
