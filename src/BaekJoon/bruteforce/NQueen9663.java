package BaekJoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen9663 {
    private static int[] board;
    private static int numberOfCases;
    private static int N;

    public static void main(String[] args) throws IOException {
        /**
         * N-Queen 문제
         */

        // 풀이 보고 끌어옴
        // 이해하고 넘어가야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        numberOfCases = 0;

        nQueen(0);
        System.out.println(numberOfCases);

    }

    public static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return 
        if (depth == N) {
            numberOfCases++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    public static boolean Possibility(int col) {

        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우) 
            if (board[col] == board[i]) {
                return false;
            }

            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
             */
            else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
