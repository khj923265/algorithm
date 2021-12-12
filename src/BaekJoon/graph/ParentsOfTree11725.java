package BaekJoon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParentsOfTree11725 {
    private static int numberOfNode;
    private static int firstNode;
    private static int secondNode;
    private static List<List<Integer>> nodeList;
    private static boolean[] visitCheck;
    private static int[] parentNodeNumbers;

    public static void main(String[] args) throws Exception {
        /**
         * 트리의 부모 찾기 문제
         */

        // 메모리 부족 int[][] -> List
        // 인접행렬과 인접리스트의 차이점 공부

        StringBuilder sb = new StringBuilder();

        numberOfNode = read();
        nodeList = new ArrayList<>();
        parentNodeNumbers = new int[numberOfNode - 1];
        visitCheck = new boolean[numberOfNode];

        int i;
        for (i = 0; i < numberOfNode; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (i = 0; i < numberOfNode - 1; i++) {
            firstNode = read() - 1;
            secondNode = read() - 1;

            nodeList.get(firstNode).add(secondNode);
            nodeList.get(secondNode).add(firstNode);
        }

        FindParentsOfTree();

        for (int parentNodeNumber : parentNodeNumbers) {
            sb.append(parentNodeNumber).append("\n");
        }
        System.out.println(sb);
    }

    private static void FindParentsOfTree() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visitCheck[0] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int node : nodeList.get(x)) {
                if (!visitCheck[node]) {
                    visitCheck[node] = true;
                    queue.add(node);
                    parentNodeNumbers[node - 1] = x + 1;
                }
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
