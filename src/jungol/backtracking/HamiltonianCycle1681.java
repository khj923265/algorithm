package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HamiltonianCycle1681 {
    private static int[][] distanceList;
    private static boolean[] isVisitCheckList;
    private static int N;
    private static int minCost;
    private static int cost;

    public static void main(String[] args) throws IOException {
        /**
         * 해밀턴 순환회로 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        distanceList = new int[N][N]; // 거리비용 리스트
        isVisitCheckList = new boolean[N]; // 각 배달장소 방문 확인 리스트
        minCost = Integer.MAX_VALUE; // 최소 비용을 저장하기 위한 변수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                distanceList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(minCost);

    }

    public static void dfs(int x) {
        // 현재 노드가 마지막 노드인지 확인을 위해
        // 방문리스트를 전부 돌려 전체방문한 상태인지 확인
        boolean isComplete = true;
        for (int i = 1; i < N; i++) {
            if (!isVisitCheckList[i]) {
                isComplete = false;
                break;
            }
        }
        // 전체 방문한 상태라면 마지막 노드기 때문에 최소 비용을 저장
        // but 배달장소에서 회사로도 갈수 없는 경우가 존재함
        // 그럴경우 불가능으로 판단 최소비용 저장 X
        if (isComplete && distanceList[x][0] != 0) {
            minCost = Math.min(minCost, cost + distanceList[x][0]);
        }

        for (int i = 1; i < N; i++) {
            if (!isVisitCheckList[i] && distanceList[x][i] != 0) {
                cost += distanceList[x][i];
                // 시간초과나서 이부분에서 백트래킹 함
                // 코스트가 이미 이전에 계산된 코스트를 초과시 굳이 탐색X
                if (minCost < cost) {
                    cost -= distanceList[x][i];
                    continue;
                }
                isVisitCheckList[i] = true;
                dfs(i);
                cost -= distanceList[x][i];
                isVisitCheckList[i] = false;
            }
        }
    }
}
