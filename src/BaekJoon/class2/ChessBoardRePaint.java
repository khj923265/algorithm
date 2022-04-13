package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessBoardRePaint {
    private static final char BLACK = 'B';
    private static final char WHITE = 'W';

    private static char[][] boardList;
    private static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        /**
         * 체스판 다시 칠하기 문제
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boardList = new char[N][M];

        for (int i = 0; i < N; i++) {
            boardList[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                minCount = Math.min(minCount, findRePaintCount(i, j, BLACK));
                minCount = Math.min(minCount, findRePaintCount(i, j, WHITE));
            }
        }

        System.out.println(minCount);

    }

    public static int findRePaintCount(int x, int y, char startColor) {
        int count = 0;
        char previousColor = startColor;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (minCount < count) return Integer.MAX_VALUE;
                if (boardList[i][j] == previousColor) {
                    previousColor = switchColor(previousColor);
                    ++count;
                } else {
                    previousColor = switchColor(previousColor);
                }
            }
            previousColor = switchColor(previousColor);
        }
        return count;
    }

    public static char switchColor(char color) {
        return color == BLACK ? WHITE : BLACK;
    }
}
