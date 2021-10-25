package BaekJoon.bruteforce;

public class PerfectCube4690 {
    public static void main(String[] args) {
        /**
         *  완전 세제곱근 문제
         *  a <= 100 이고 a~d 모두 2 이상의 자연수일 경우
         *  a^3 = b^3 + c^3 + d^3 조건을 만족하는 경우를 출력하기.
         */

        // ex)
        // Cube = 6, Triple = (3,4,5)
        // Cube = 12, Triple = (6,8,10)
        // Cube = 18, Triple = (2,12,16)
        // Cube = 18, Triple = (9,12,15)

        for (int i = 6; i <= 100; i++) {
            for (int j = 2; j < i; j++) {
                for (int k = j; k < i; k++) {
                    for (int l = k; l < i; l++) {
                        if (getCube(i) == getCube(j) + getCube(k) + getCube(l)){
                            printCube(i, j, k, l);
                        }
                    }
                }
            }
        }
    }

    static void printCube(int a, int b, int c, int d) {
        System.out.println("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")");
    }

    static int getCube(int num) {
        return num*num*num;
    }
}
