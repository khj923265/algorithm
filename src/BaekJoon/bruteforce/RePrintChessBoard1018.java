package BaekJoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RePrintChessBoard1018 {
    private static String[][] boards;

    public static void main(String[] args) throws IOException {
        /**
         * 체스판 다시칠하기 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] boardSize = br.readLine().split(" ");
        int N = Integer.parseInt(boardSize[0]);
        int M = Integer.parseInt(boardSize[1]);
        boards = new String[N][M];

        for (int i = 0; i < N; i++) {
            boards[i] = br.readLine().split("");
        }

    }

    private static void CountRePrintBoard(int x, int y) {
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

            }
        }
    }
}
