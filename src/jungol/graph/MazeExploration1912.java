package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MazeExploration1912 {

    private static int N;
    private static boolean[] visited;
    private static List<List<Integer>> rooms = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        /**
         * 미로 탐색 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 방의 수
        int M = Integer.parseInt(st.nextToken()); // 문의 수

        for (int i = 0; i < N; i++) {
            rooms.add(new ArrayList<>());
        }
        visited = new boolean[N];
        int firstNumber;
        int secondNumber;
        String[] strings;
        for (int i = 0; i < M; i++) {
            strings = br.readLine().split(" ");
            firstNumber = Integer.parseInt(strings[0]) - 1;
            secondNumber = Integer.parseInt(strings[1]) - 1;
            rooms.get(firstNumber).add(secondNumber);
            rooms.get(secondNumber).add(firstNumber);
        }

        for (List<Integer> list : rooms) {
            list.sort(Integer::compareTo);
        }
        dfs(0);
    }

    private static void dfs (int roomNumber) {
        visited[roomNumber] = true;
        list.add(roomNumber);
        if (list.size() == N) {
            printResult();
            System.exit(0);
        }
        for (int nextRoomNumber : rooms.get(roomNumber)) {
            if (!visited[nextRoomNumber]) {
                dfs(nextRoomNumber);
            }
        }
    }

    private static void printResult () {
        StringBuilder sb = new StringBuilder();
        for (int roomNumber : list) {
            sb.append(roomNumber + 1).append(" ");
        }
        System.out.println(sb);
    }
}
