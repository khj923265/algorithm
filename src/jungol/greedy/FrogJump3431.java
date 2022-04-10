package jungol.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FrogJump3431 {

    public static void main(String[] args) throws IOException {
        /**
         * 개구리 점프 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 통나무 개수
        int Q = Integer.parseInt(input[1]); // 질문의 개수
        StringTokenizer st;

        int[] parent = new int[N + 1];
        int[] size = new int[N + 1];
        Node[] nodes = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        nodes[0] = new Node(-1, -1, -1);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(nodes);
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (nodes[i].x2 >= nodes[j].x1) {
                    union(nodes[i].idx, nodes[j].idx, parent, size);
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (Q --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int r1 = find(u, parent);
            int r2 = find(v, parent);

            if (r1 == r2) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }
        System.out.print(sb);
    }



    // 최상위 부모 노드를 찾는 메서드
    static int find(int a, int[] parent) {
        return a == parent[a] ? a : (parent[a] = find(parent[a], parent));
    }

    // 자신의 부모 노드 번호를 바꿔주는 부분
    static void union(int a, int b, int[] parent, int[] size) {
        int r1 = find(a, parent);
        int r2 = find(b, parent);

        if (size[r1] > size[r2]) {
            int temp = r1;
            r1 = r2;
            r2 = temp;
        }

        parent[r1] = r2;
        size[r2] += size[r1];
    }

}

class Node implements Comparable<Node> {
    int x1;
    int x2;
    int idx;

    Node(int x1, int x2, int idx) {
        this.x1 = x1;
        this.x2 = x2;
        this.idx = idx;
    }

    public int compareTo(Node that) {
        return this.x1 - that.x1;
    }
}