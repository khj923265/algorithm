package BaekJoon.practice;

import java.util.ArrayList;
import java.util.List;

public class MusicalScales2920 {

    public static void main(String[] args) throws Exception {
        /**
         *  음계 문제
         *  입력값이 1 ~ 8 이면 ascending
         *  8 ~ 1 이면 descending
         *  그 외는 mixed 를 출력하기.
         */

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            list.add(read());
        }

        if (list.get(0) == 1) {
            for (int i = 1; i < 8; i++) {
                if (!(list.get(i) == i + 1)){
                    System.out.println("mixed");
                    break;
                }
                if (i == 7 && list.get(i) == 8) {
                    System.out.println("ascending");
                    break;
                }
            }
        } else if (list.get(0) == 8) {
            for (int i = 1; i < 8 ; i++) {
                if (!(list.get(i) == 8 - i)){
                    System.out.println("mixed");
                    break;
                }
                if (i == 7 && list.get(i) == 1) {
                    System.out.println("descending");
                    break;
                }
            }
        } else {
            System.out.println("mixed");
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
