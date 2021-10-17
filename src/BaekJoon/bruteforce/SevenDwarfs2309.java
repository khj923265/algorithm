package BaekJoon.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class SevenDwarfs2309 {
    final static int testCase = 9;

    public static void main(String[] args) throws Exception {
        /**
         *  일곱 난쟁이 문제
         *  9개의 라인에서 7개를 선택해 합이 100 이 되는 경우를 구해
         *  7개를 오름차순으로 출력하시오.
         */

        List<Integer> dwarfList = new ArrayList<>();
        int maxSum = 0;
        int sum = 0;
        int liarIndex1 = 0;
        int liarIndex2 = 0;

        for (int i = 0; i < testCase; i++) {
            dwarfList.add(read());
        }
        // 오름차순 정렬 먼저 실행
        dwarfList.sort(Integer::compareTo);
        // 9개의 합산을 구해놓고 그값과 제외할 2명 + 100 값과 비교
        for (int i = 0; i < testCase; i++) {
            maxSum += dwarfList.get(i);
        }

        // 전체탐색 실행 7명의 합산을 찾는게 아니라 제외할 2명을 찾는다
        loop:
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < testCase; j++) {
                if (i != j) {
                    sum = dwarfList.get(i) + dwarfList.get(j) + 100;
                    if (maxSum == sum) {
                        liarIndex1 = i;
                        liarIndex2 = j;
                        break loop;
                    }
                }
            }
        }

        // 거짓말하는 난장이 2명을 제외한 나머지 7명을 출력
        for (int i = 0; i < testCase; i++) {
            if (i != liarIndex1 && i != liarIndex2) {
                System.out.println(dwarfList.get(i));
            }
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
