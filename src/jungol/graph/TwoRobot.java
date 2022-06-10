package jungol.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TwoRobot {
    private static int N;
    private static int A_ROBOT_NODE;
    private static int B_ROBOT_NODE;
    private static int[][] distances;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    private static boolean[] visited_A;
    private static boolean[] visited_B;

    public static void main(String[] args) throws IOException {
        /**
         * 두 로봇 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A;
        int B;
        int distance;
        N = Integer.parseInt(st.nextToken());
        A_ROBOT_NODE = Integer.parseInt(st.nextToken()) - 1;
        B_ROBOT_NODE = Integer.parseInt(st.nextToken()) - 1;

        distances = new int[N][N];
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken()) - 1;
            B = Integer.parseInt(st.nextToken()) - 1;
            distance = Integer.parseInt(st.nextToken());

            distances[A][B] = distance;
            distances[B][A] = distance;
            list.get(A).add(B);
            list.get(B).add(A);
        }

        System.out.println();


    }
}
