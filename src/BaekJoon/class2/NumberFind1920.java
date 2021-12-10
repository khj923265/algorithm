package BaekJoon.class2;

import java.util.HashMap;
import java.util.Map;

public class NumberFind1920 {

    public static void main(String[] args) throws Exception {
        /**
         * 수찾기 문제
         */

        // 그냥 배열로 contains 사용하면 시간초과
        // map 에 담아서 키 값 존재여부로 하니 성공
        // 배열에 담아서 정렬하고 이분탐색으로 푸는 사람도 있었는데 큰차이는 없었다.(아마 정렬에서 많이 잡아먹은듯)
        StringBuilder sb = new StringBuilder();
        Map<Integer, Boolean> map = new HashMap<>();

        int N = read();

        for (int i = 0; i < N; i++) {
            map.put(read(), true);
        }

        int M = read();
        while (M --> 0) {
            if (map.containsKey(read())) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
