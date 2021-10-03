package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SubSequence11722 {

    public static void main(String[] args) throws IOException {
        /**
         * 가장 긴 감소하는 수열
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> dpList = new ArrayList<>();
        dpList.add(0); // 0 번째에 0 삽입

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value < dpList.get(dpList.size() - 1)) {
                dpList.add(value);
            } else {
                int left = 0;
                int right = dpList.size() - 1;

                while(left < right){
                    int mid = (left + right) / 2;
                    if(dpList.get(mid) <= value){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                dpList.set(right, value);
            }
        }
        System.out.println(dpList);
        System.out.println(dpList.size());

        for (int i = 1; i < dpList.size(); i++) {
            System.out.print(dpList.get(i) + " ");
        }
    }

}
