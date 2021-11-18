package BaekJoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordSort1181 {

    public static void main(String[] args) throws IOException {
        /**
         *  단어정렬 문제
         */

        // 입력된 단어들을 길이만큼정렬하고 사전순으로 정렬해 출력하기(중복은 제거)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> wordList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            wordList.add(br.readLine());
        }
        List<String> sortedWord = wordList.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .collect(Collectors.toList());
        for (String word : sortedWord) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }

}
