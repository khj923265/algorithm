package jungol.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Delivery2641 {

    public static void main(String[] args) throws IOException {
        /**
         * 택배 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sts = br.readLine().split(" ");
        int N = Integer.parseInt(sts[0]); // 마을의 개수
        int C = Integer.parseInt(sts[1]); // 트럭의 용량
        int M = Integer.parseInt(br.readLine()); // 보내는 박스의 정보개수
        int[][] list = new int[M][M];
        int[] capacityList = new int[M-1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] a = new int[3];
            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());
            a[2] = Integer.parseInt(st.nextToken());
            list[i] = a;
        }

        for (int i = 0; i < M - 1; i++) {
            capacityList[i] = C;
        }

        List<int[]> sortedList = Arrays.stream(list).sorted((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        }).collect(Collectors.toList());

        int result = 0;

        //TODO 해결해야함!
        for (int[] ints : sortedList) {
            int startNum = ints[0] - 1;
            int capacity = ints[2];
            if (capacity <= capacityList[startNum]) {
                capacityList[startNum] -= capacity;
                result += capacity;
            } else {
                result += capacityList[startNum];
                capacityList[startNum] = 0;
            }
        }

        System.out.println(result);

    }
}
