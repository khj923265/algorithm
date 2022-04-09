package programers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestOne {

    private static Set<Integer> rentalOfficeNumbers;

    public static void main(String[] args) {

        // n 개의 노드가 있고 loads 에는 (a, b, 두 노드사이의 거리)
        // 거리 1당 1분이 소요된다고 가정시 k 분 동안 이동해서 정확히 노드에 도착한다면 해당 노드 번호를 반환

        int n = 4;
        int k = 11;

        int[][] loads = {
                {0,1,2},
                {1,2,7},
                {2,3,10},
                {3,10,9},
                        };

        int[][] list = new int[loads.length][loads.length];

        rentalOfficeNumbers = new HashSet<>();

        for (int[] load : loads) {
            list[load[0]][load[1]] = load[2];
            list[load[1]][load[0]] = load[2];
        }

        dfs(loads, list, k, 0, 0);

        List<Integer> a = rentalOfficeNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(a);

    }

    public static void dfs(int[][] loads, int[][] list,int k, int time, int rentalOfficeNumber) {
        if (k < time) {
            return;
        } else if (k == time){
            rentalOfficeNumbers.add(rentalOfficeNumber);
            return;
        }

        for (int i = 0; i < loads.length; i++) {
            if (list[rentalOfficeNumber][i] != 0) {
                dfs(loads,list,k,time + list[rentalOfficeNumber][i],i);
            }
        }
    }
}
