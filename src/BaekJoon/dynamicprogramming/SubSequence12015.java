package BaekJoon.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class SubSequence12015 {

    public static void main(String[] args) throws Exception {
        /**
         * 가장 긴 증가하는 부분 수열2 문제
         */

        int N = read();
        List<Integer> dpList = new ArrayList<>();
        dpList.add(0); // 0 번째에 0 삽입

        for(int i = 0; i < N; i++) {
            int value = read();

            if (dpList.get(dpList.size() - 1) < value) {
                dpList.add(value);
            } else {
                int left = 0;
                int right = dpList.size() - 1;

                while(left < right){
                    int mid = (left + right) / 2;
                    if(dpList.get(mid) >= value){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                dpList.set(right, value);
            }
        }
        System.out.println(dpList.size() - 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
