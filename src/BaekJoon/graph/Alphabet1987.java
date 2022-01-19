package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Alphabet1987 {
    private static int N;
    private static int M;
    private static int maxCount;
    private static char[][] board;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        /**
         * 알파벳 문제
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        maxCount = 1;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        bfs();

        System.out.println(maxCount);

    }

    private static void bfs() {
        Queue<Horse> queue = new LinkedList<>();
        List<Character> charList = new ArrayList<>();
        charList.add(board[0][0]);
        queue.offer(new Horse(0, 0, 1, charList));

        while (!queue.isEmpty()) {
            Horse horse = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = horse.x + dx[i];
                int my = horse.y + dy[i];

                if (0 <= mx && 0 <= my && mx < N && my < M && !horse.alphabets.contains(board[mx][my])) {
                    if (maxCount < horse.count + 1) maxCount = horse.count + 1;
                    List<Character> list = new ArrayList<>(horse.alphabets);
                    list.add(board[mx][my]);
                    queue.offer(new Horse(mx, my, horse.count + 1, list));
                }
            }
        }
    }

    private static class Horse {
        int x;
        int y;
        int count;
        List<Character> alphabets;

        private Horse(int x, int y, int count, List<Character> alphabets) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.alphabets = alphabets;
        }
    }

}
