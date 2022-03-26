package jungol.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Refrigerator1828 {

    public static void main(String[] args) throws Exception {
        /**
         * 냉장고 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chemicalTemperatures = new int[n][2];
        int refrigeratorOfNumber = 1;

        for (int i = 0; i < n; i++) {
            String[] inputLine = br.readLine().split(" ");
            chemicalTemperatures[i][0] = Integer.parseInt(inputLine[0]);
            chemicalTemperatures[i][1] = Integer.parseInt(inputLine[1]);
        }

        Arrays.sort(chemicalTemperatures, Comparator.comparingInt(value -> value[0]));
        List<int[]> sortedChemicalTemperatures = Arrays.stream(chemicalTemperatures)
                .sorted((o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return Integer.compare(o1[0], o2[0]);
                    } else {
                        return Integer.compare(o1[1], o2[1]);
                    }
                }).collect(Collectors.toList());

        int maxTemperature = sortedChemicalTemperatures.get(0)[1];

        for (int i = 1; i < n; i++) {
            if (maxTemperature < sortedChemicalTemperatures.get(i)[0]) {
                ++refrigeratorOfNumber;
                maxTemperature = sortedChemicalTemperatures.get(i)[1];
            }
        }

        System.out.println(refrigeratorOfNumber);

    }
}
