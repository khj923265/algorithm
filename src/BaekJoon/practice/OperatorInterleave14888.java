package BaekJoon.practice;

public class OperatorInterleave14888 {
    private static int[] numbers;
    private static int[] operators;
    private static int[] operators2;
    private static int N;

    public static void main(String[] args) throws Exception {
        /**
         * 연산자 끼워넣기 문제
         */

        // 덧셈 / 뺄셈 / 곱셈 / 나눗셈

        //TODO 수정해야함!

        N = read();
        numbers = new int[N];
        operators = new int[4];
        operators2 = new int[4];

        insertNumbers();
        insertOperators();

        int maxNum = numbers[0];
        int minNum = numbers[0];

        for (int i = 1; i < N; i++) {
            if (0 < operators[1]) {
                maxNum -= numbers[i];
                --operators[1];
            } else if (0 < operators[3]){
                maxNum /= numbers[i];
                --operators[3];
            } else if (0 < operators[0]){
                maxNum += numbers[i];
                --operators[0];
            } else if (0 < operators[2]){
                maxNum *= numbers[i];
                --operators[2];
            }
        }

        for (int i = 1; i < N; i++) {
            if (0 < operators2[0]) {
                minNum += numbers[i];
                --operators2[0];
            } else if (0 < operators2[3]){
                minNum /= numbers[i];
                --operators2[3];
            } else if (0 < operators2[1]){
                minNum -= numbers[i];
                --operators2[1];
            } else if (0 < operators2[2]){
                minNum *= numbers[i];
                --operators2[2];
            }
        }
        System.out.println(maxNum);
        System.out.println(minNum);

    }

    private static void calculateNumbers() {

    }

    private static void insertNumbers() throws Exception {
        for (int i = 0; i < N; i++) {
            numbers[i] = read();
        }
    }

    private static void insertOperators() throws Exception {
        for (int i = 0; i < 4; i++) {
            int num = read();
            operators[i] = num;
            operators2[i] = num;
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
