package BaekJoon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph1707{
    private static List<List<Integer>> list;
    private static int[] colors;
    private static boolean isBipartiteGraph;

    public static void main(String[] args) throws Exception {
        /**
         *  이분 그래프 문제
          */

        int testCase = read();

        while (testCase --> 0) {
            int nodeOfNumber = read();
            int edgeOfNumber = read();

            list = new ArrayList<>();
            colors = new int[nodeOfNumber + 1];
            isBipartiteGraph = true;

            for (int i = 0; i <= nodeOfNumber; i++) {
                list.add(new ArrayList<>());
                colors[i] = 0;
            }

            while (edgeOfNumber --> 0) {
                int firstNodeNum = read();
                int secondNodeNum = read();
                list.get(firstNodeNum).add(secondNodeNum);
                list.get(secondNodeNum).add(firstNodeNum);
            }

            for (int i = 0; i < nodeOfNumber; i++) {
                if (!isBipartiteGraph) break;

                if (colors[i] == 0) {
                    bfs(i);
                }
            }

            System.out.println(isBipartiteGraph ? "YES" : "NO");
        }
    }

    private static void bfs(int nodeNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nodeNum);
        colors[nodeNum] = 1;

        while (!queue.isEmpty() && isBipartiteGraph) {
            int QNodeNum = queue.poll();

            for (int adjacencyNode : list.get(QNodeNum)) {
                if (colors[adjacencyNode] == colors[QNodeNum]) {
                    isBipartiteGraph = false;
                    break;
                }
                if (colors[adjacencyNode] == 0) {
                    colors[adjacencyNode] = colors[QNodeNum] * -1;
                    queue.offer(adjacencyNode);
                }
            }
        }

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
}
