package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku1824 {
    private static char[][] sudokuList = new char[9][9];

    public static void main(String[] args) throws IOException {
        /**
         * 수도쿠 문제
         */

        // 가로/세로/그룹 의 빈값을 배열로 받아서 중첩되는게 1개로 좁혀지면 해당값을 입력
        // 만약 빈값이 1개일 경우 바로 그값을 넣고 리턴
        // 배열에 0이 없을 때까지 반복

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            sudokuList[i] = br.readLine().replace(" ","").toCharArray();
        }

        sudoku(0, 0);

    }

    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudokuList[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        if (sudokuList[row][col] == '0') {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, (char)(i + '0'))) {
                    sudokuList[row][col] = (char)(i + '0');
                    sudoku(row, col + 1);
                }
            }
            sudokuList[row][col] = '0';
            return;
        }
        sudoku(row, col + 1);
    }

    public static boolean possibility(int row, int col, char value) {

        // 같은 행,열 에 있는 원소들 중 겹치는 열 원소가 있는지 검사.
        for (int i = 0; i < 9; i++) {
            if (sudokuList[row][i] == value) {
                return false;
            }
            if (sudokuList[i][col] == value) {
                return false;
            }
        }

        int set_row = (row / 3) * 3;	// value가 속한 3x3의 행의 첫 위치
        int set_col = (col / 3) * 3;	// value가 속한 3x3의 열의 첫 위치

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (sudokuList[i][j] == value) {
                    return false;
                }
            }
        }

        return true;	// 중복되는 것이 없을 경우 true 반환
    }
}
