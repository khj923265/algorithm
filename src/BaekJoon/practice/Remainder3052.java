package BaekJoon.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Remainder3052 {

    public static void main(String[] args) throws Exception {
        /**
         * 나머지 문제
         * 10개의 자연수를 42로 나눈 나머지를 구한 후
         * 그 나머지가 서로 다른게 몇개인지 출력하기.
         */
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numberList.add(read()%42);
        }

        Set<Integer> remainderSet = new HashSet<>(numberList);

        System.out.println(remainderSet.size());

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
