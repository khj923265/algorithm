package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class WordStudy1157 {

    public static void main(String[] args) throws IOException {
        /**
         *  단어 공부 문제
         *  영어로 된 단어를 입력받고 중복된 알파벳이 가장 많은 개수를 출력하기.
         *  가장 많은 개수가 같은게 있으면 ? 를 출력
         */

        // 메모리를 좀 많이 먹음 이것저것 너무 복잡하게 푼듯...

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase(Locale.ROOT);
        char[] charArr = word.toCharArray();
        int[] alphabetCountArr = new int[27];
        int max = 0;
        int maxIndex = 0;
        int maxIndex2 = 0;

        for (char alphabet : charArr) {
            byte alphabetByte = (byte) alphabet;
            alphabetCountArr[alphabetByte - 64] += 1;
        }

        for (int i = 0; i < alphabetCountArr.length; i++) {
            if (max < alphabetCountArr[i]) {
                max = alphabetCountArr[i];
                maxIndex = i;
            } else if (max == alphabetCountArr[i]) {
                maxIndex2 = i;
            }
        }

        if (alphabetCountArr[maxIndex] != alphabetCountArr[maxIndex2]) {
            System.out.println((char) (maxIndex + 64));
        } else {
            System.out.println("?");
        }

    }
}
