package BaekJoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CandyGame3085 {

    static String temp;
    static int testCase;

    public static void main(String[] args) throws IOException {
        /**
         *  사탕 게임
         *  N x N 크기의 상자 각각 1개의 사탕이 들어간다 (빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y)
         *  같은 색으로 연속된 부분은 다 먹을 수 있다면 가장 많이 먹을 수 있는 수를 구하라.
         */

        //TODO 틀렸습니다 뜸 뭐가 문제인지 띵낑해보자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        String[][] box = new String[testCase][testCase];
        int maxCount = 0;

        for (int i = 0; i < testCase; i++) {
            String[] boxRow = br.readLine().split("");
            box[i] = boxRow;
        }

        /**
         * YCPZY
         * CYZZP
         * CCPPP
         * YCYZC
         * CPPZZ
         */

        Loop:
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < testCase; j++) {
                if (i == testCase - 1 && j == testCase - 1) {
                    //가장 마지막 값
                    break;
                } else if (i == testCase - 1) {
                    maxCount = getMaxCountAndSwitchColumn(box, maxCount, i, j);
                    if (maxCount == testCase) break Loop;
                } else if (j == testCase - 1) {
                    maxCount = getMaxCountAndSwitchRow(box, maxCount, i, j);
                    if (maxCount == testCase) break Loop;
                } else {
                    maxCount = getMaxCountAndSwitchColumn(box, maxCount, i, j);
                    if (maxCount == testCase) break Loop;
                    maxCount = getMaxCountAndSwitchRow(box, maxCount, i, j);
                    if (maxCount == testCase) break Loop;
                }
            }
        }

        System.out.println(maxCount);
    }

    private static int getMaxCountAndSwitchRow(String[][] box, int maxCount, int i, int j) {
        //if (!box[i][j].equals(box[i + 1][j])) {
            temp = box[i][j];
            box[i][j] = box[i + 1][j];
            box[i + 1][j] = temp;

            int count = getMaxCount(box, maxCount);
            maxCount = Math.max(maxCount, count);

            box[i + 1][j] = box[i][j];
            box[i][j] = temp;
        //}
        return maxCount;
    }

    private static int getMaxCountAndSwitchColumn(String[][] box, int maxCount, int i, int j) {
        //if (!box[i][j].equals(box[i][j + 1])) {
            temp = box[i][j];
            box[i][j] = box[i][j + 1];
            box[i][j + 1] = temp;

            int count = getMaxCount(box, maxCount);
            maxCount = Math.max(maxCount, count);

            box[i][j + 1] = box[i][j];
            box[i][j] = temp;
        //}
        return maxCount;
    }

    private static int getMaxCount(String[][] box, int maxCount) {
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < testCase; j++) {
                if (i == j) {
                    List<String> tempList = Arrays.asList(box[i]);
                    int redCount = 0;
                    int blueCount = 0;
                    int greenCount = 0;
                    int yellowCount = 0;

                    redCount = Collections.frequency(tempList, "C");
                    blueCount = Collections.frequency(tempList, "P");
                    greenCount = Collections.frequency(tempList, "Z");
                    yellowCount = Collections.frequency(tempList, "Y");

                    int maxRowCount = Math.max(Math.max(Math.max(redCount, blueCount), greenCount),
                        yellowCount);

                    redCount = 0;
                    blueCount = 0;
                    greenCount = 0;
                    yellowCount = 0;

                    for (int k = 0; k < testCase; k++) {
                        if ("C".equals(box[k][j])) {
                            redCount += 1;
                        } else if ("P".equals(box[k][j])) {
                            blueCount += 1;
                        } else if ("Z".equals(box[k][j])) {
                            greenCount += 1;
                        } else if ("Y".equals(box[k][j])) {
                            yellowCount += 1;
                        }
                    }

                    int maxColumnCount = Math.max(
                        Math.max(Math.max(redCount, blueCount), greenCount),
                        yellowCount);

                    maxCount = Math.max(Math.max(maxRowCount, maxColumnCount), maxCount);
                }
            }
        }
        return maxCount;
    }
}
