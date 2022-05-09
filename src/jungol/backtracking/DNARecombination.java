package jungol.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DNARecombination {
    private static String recombined;

    public static void main(String[] args) throws IOException {
        /**
         *  DNA 조합 문제
         */

        /**
         * 4
         * GATTA
         * TAGG
         * ATCGA
         * CGCAT
         * 해당 케이스 왜 13인지 해결못함
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];

        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }
        recombined = strings[0];

        for (int i = 0; i < strings.length - 1; i++) {
            reCombination(recombined, strings[i + 1]);
        }
        System.out.println(recombined);
        System.out.println(recombined.length());
    }

    private static void reCombination(String leftString, String rightString) {
        int minStringLength = Math.min(leftString.length(), rightString.length());

        recombined = recombined + getCompareStringDifferences(leftString, rightString, minStringLength);
    }

    private static String getCompareStringDifferences(String leftString, String rightString, int toCompareLength) {
        if (toCompareLength == 0) {
            return rightString;
        }
        String cutLeftString = leftString.substring(leftString.length()-toCompareLength);
        String cutRightString = rightString.substring(0, toCompareLength);

        if (cutLeftString.equals(cutRightString)) {
            return rightString.substring(toCompareLength);
        }
        return getCompareStringDifferences(leftString, rightString, toCompareLength - 1);
    }

}
