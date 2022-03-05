package BaekJoon.practice;

public class OperatorInterleave14888 {
    private static int[] numbers;
    private static int[] operatorsIndex;
    private static int maxNumber;
    private static int minNumber;
    private static int N;

    public static void main(String[] args) throws Exception {
        /**
         * 연산자 끼워넣기 문제
         */

        // 정답은 나왔으나 왜 백트래킹인지 이해를 못함

        N = read();
        numbers = new int[N];
        operatorsIndex = new int[4];
        maxNumber = Integer.MIN_VALUE;
        minNumber = Integer.MAX_VALUE;


        insertNumbers();
        insertOperators();

        DFS(numbers[0],1);

        System.out.println(maxNumber);
        System.out.println(minNumber);
    }

    private static void DFS(int num, int count) {
        if (count == N) {
            maxNumber = Math.max(maxNumber, num);
            minNumber = Math.min(minNumber, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (0 < operatorsIndex[i]) {
                operatorsIndex[i]--;
                switch (i) {
                    case 0:
                        DFS(num + numbers[count], count + 1);
                        break;
                    case 1:
                        DFS(num - numbers[count], count + 1);
                        break;
                    case 2:
                        DFS(num * numbers[count], count + 1);
                        break;
                    case 3:
                        DFS(num / numbers[count], count + 1);
                        break;
                }
                operatorsIndex[i]++;
            }
        }

    }

    private static void insertNumbers() throws Exception {
        for (int i = 0; i < N; i++) {
            numbers[i] = read();
        }
    }

    private static void insertOperators() throws Exception {
        for (int i = 0; i < 4; i++) {
            operatorsIndex[i] = read();
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
