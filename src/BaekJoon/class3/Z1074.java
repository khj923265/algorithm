package BaekJoon.class3;

public class Z1074 {
    /**
     * Z 문제
     */

    private static int[] dx = {0, 0, 1, 1};
    private static int[] dy = {0, 1, 0, 1};
    private static int row;
    private static int col;

    private static int count = 0;
    private static int[][] list;

    public static void main(String[] args) throws Exception {
        int N = read();
        row = read();
        col = read();
        int index = (int) Math.pow(2, N);
        list = new int[index][index];
        z(0, 0, index - 1, index - 1);
    }

    //TODO list 쓰지말고 그냥 값으로만 나누면서 사분면을 계속 쪼개서 찾아야함
    private static void z(int startX, int startY, int endX, int endY) {
//        if (row < startX || col < startY
//                || endX < row || endY < col) {
//            int x = Math.abs(startX - endX) + 1;
//            int y = Math.abs(startY - endY) + 1;
//            count = count + (x * y);
//            return;
//        }
        if (Math.abs(startX - endX) == 1) {
            countZ(startX, startY);
            return;
        }
        z(startX, startY, (endX) / 2, (endY) / 2);
        z(startX, (endY + 1) / 2, (endX) / 2, endY);
        z((endX + 1) / 2, startY, endX, (endY) / 2);
        z((endX + 1) / 2, (endY + 1) / 2, endX, endY);
    }

    private static void countZ(int startX, int startY) {
        for (int i = 0; i < 4; i++) {
            int sX = startX + dx[i];
            int sY = startY + dy[i];
            if (sX == row && sY == col) {
                System.out.println(count);
                System.exit(0);
            }
            count = count + 1;
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