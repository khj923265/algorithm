package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RouteFind2261 {
    private static int N;
    private static int K;
    private static int A;
    private static int B;
    private static boolean[] visited;
    private static char[][] code;
    private static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        /**
         * 경로 찾기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        code = new char[N][K];
        visited = new boolean[N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            code[i] = br.readLine().toCharArray();
        }
        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken()) - 1; // 시작 번호
        B = Integer.parseInt(st.nextToken()) - 1; // 이동할 번호

        insertHammingCodeList();

        Hamming hamming = bfs();

        if (hamming.index == -1) {
            System.out.println(-1);
        }
        hamming.list.forEach(i -> System.out.print((i + 1) + " "));
    }

    private static void insertHammingCodeList() {
        int count;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i != j) {
                    count = 0;
                    for (int k = 0; k < K; k++) {
                        if (1 < count) {
                            break;
                        }
                        if (code[i][k] != code[j][k]) {
                            count = count + 1;
                        }
                    }
                    if (count == 1) {
                        list.get(i).add(j);
                        list.get(j).add(i);
                    }
                }
            }
        }
    }

    public static Hamming bfs() {
        Queue<Hamming> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(A);
        queue.offer(new Hamming(A, arrayList));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Hamming hamming = queue.poll();

            for (int next : list.get(hamming.index)) {
                if (visited[next]) {
                    continue;
                }
                visited[hamming.index] = true;
                if (next == B) {
                    hamming.list.add(B);
                    return hamming;
                }
                ArrayList<Integer> arrayList1 = new ArrayList<>(hamming.list);
                arrayList1.add(next);
                queue.offer(new Hamming(next, arrayList1));
            }
        }
        return new Hamming(-1, new ArrayList<>());
    }

    public static class Hamming {
        public int index;
        public ArrayList<Integer> list;

        public Hamming(int index, ArrayList<Integer> list) {
            this.index = index;
            this.list = new ArrayList<>();
            this.list.addAll(list);
        }
    }
}
