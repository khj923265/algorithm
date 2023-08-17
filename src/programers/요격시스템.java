package programers;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {

    static int[][] targets = {
            {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}, {10, 14}
    };

    public static void main(String[] args) {
        solution(targets);
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        int start = Integer.MAX_VALUE;

        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]); // 첫 번째 값 오름차순
            }
        });

        for (int[] target : targets) {
            if (target[1] <= start) {
                answer = answer + 1;
                start = target[0];
            }
        }

        return answer;
    }
}
