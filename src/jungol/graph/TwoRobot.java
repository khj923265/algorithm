package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoRobot {
    private static int N;
    private static int A_ROBOT_NODE;
    private static int B_ROBOT_NODE;
    private static ArrayList<ArrayList<Node>> tree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /**
         * 두 로봇 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        A_ROBOT_NODE = Integer.parseInt(st.nextToken()) - 1;
        B_ROBOT_NODE = Integer.parseInt(st.nextToken()) - 1;
        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (A_ROBOT_NODE == B_ROBOT_NODE) {
            System.out.println(0);
            return;
        }
        visited = new boolean[N];
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        int A;
        int B;
        int distance;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken()) - 1;
            B = Integer.parseInt(st.nextToken()) - 1;
            distance = Integer.parseInt(st.nextToken());

            tree.get(A).add(new Node(B, distance));
            tree.get(B).add(new Node(A, distance));
        }

        int result = findMinimumTravelDistance();
        System.out.println(result);


    }

    public static int findMinimumTravelDistance() {
        // Pair = 노드번호, 합산 거리, 가장 긴 거리
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(A_ROBOT_NODE, 0,  0));
        visited[A_ROBOT_NODE] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (Node node : tree.get(pair.node)) {
                // 두번째 로봇을 만났을 경우
                if (B_ROBOT_NODE == node.node) {
                    // 그동안 합산했던 거리값과 B 로봇을 만났을 떄의 거리값을 더한 후 다시 max 값을 빼서 리턴
                    return pair.sum + node.distance - Math.max(node.distance, pair.max);
                }
                if (!visited[node.node]) {
                    visited[node.node] = true;
                    queue.offer(new Pair(node.node, pair.sum + node.distance, Math.max(pair.max, node.distance)));
                }
            }
        }
        return 0;
    }

    public static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class Pair {
        int node;
        int sum;
        int max;

        public Pair(int node, int sum, int max) {
            this.node = node;
            this.sum = sum;
            this.max = max;
        }
    }
}
