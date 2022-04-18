package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bishop1662 {
    private static int[][] list;
    private static int N;
    private static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        /**
         * 비숍 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        N = Integer.parseInt(br.readLine());

        list = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bishop(0, 0, 0);
        result = maxCount;
        maxCount = 0;
        bishop(1, 1, 0);
        result += maxCount;

        System.out.println(result);
    }
    public static void bishop(int row, int col, int count) {
        if (N <= col) {
            bishop(row + 1, 0, count);
            return;
        }

        if (N <= row) {
            maxCount = Math.max(maxCount, count);
            return;
        }

        if (list[row][col] == 0) {
            if (isPossibility(row, col)) {
                list[row][col] = -1;
                bishop(row, col + 2, count + 1);
                list[row][col] = 0;
                return;
            }
        }
        bishop(row, col + 2, count);
    }

    public static boolean isPossibility(int row, int col) {
        if (row == 0) return true;

        if (col == 0) {
            // 오른쪽 상단만 탐색
            for (int i = 0; i < row; i++) {
                if (list[i][row - i] == -1) {
                    return false;
                }
            }
        } else if (col == N - 1) {
            // 왼쪽 상단만 탐색
            for (int i = 1; i <= col; i++) {
                if (list[i][col - i] == -1) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < row; i++) {
                if (list[i][row - i] == -1) {
                    return false;
                }
            }
            for (int i = 1; i <= col; i++) {
                if (list[i][col - i] == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
