package programers.skillcheck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        int[][] routes = new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int result = solution(routes);
        System.out.println(result);
    }

    
    // 코어 문제 (효율 실패)
    public static int solution(int n, int[] cores) {
        int answer = 0;
        int coreSize = cores.length;
        int[] coreTime = new int[coreSize];
        System.arraycopy(cores, 0, coreTime, 0, coreSize);

        for (int i = 0; i < coreSize; i++) {
            n = n - 1;
            if (n == 0) {
                answer = i;
            }
            coreTime[i] = coreTime[i] - 1;
        }
        int index = 0;
        while (answer == 0) {
            if (coreTime[index] != 0) {
                coreTime[index] = coreTime[index] - 1;
                if (index == coreSize - 1) {
                    index = 0;
                } else {
                    index = index + 1;
                }
                continue;
            }
            n = n - 1;
            if (n == 0) {
                answer = index;
                break;
            }
            coreTime[index] = cores[index] - 1;
            if (index == coreSize - 1) {
                index = 0;
            } else {
                index = index + 1;
            }
        }
        
        return answer + 1;
    }

    // 고속도로 최소 카메라 설치 문제 (효율 실패)
    public static int solution(int[][] routes) {
        int answer = 0;

        int routeSize = routes.length;

        List<int[]> sortedRoutesList = Arrays.stream(routes)
                .sorted((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    }
                    return o1[0] - o2[0];
                }).collect(Collectors.toList());

        int endPoint = sortedRoutesList.get(0)[1];

        for (int i = 1; i < routeSize; i++) {
            if (endPoint < sortedRoutesList.get(i)[0]) {
                ++answer;
                endPoint = sortedRoutesList.get(i)[1];
            } else {
                if (sortedRoutesList.get(i)[1] < endPoint) {
                    endPoint = sortedRoutesList.get(i)[1];
                }
            }
        }

        return answer;
    }
}
