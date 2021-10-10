package goorm.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Measure {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(br.readLine());
        List<Integer> measureList = new ArrayList<>();

        for (int i = 1; i <= inputNumber/2; i++) {
            if (inputNumber % i == 0) {
                measureList.add(i);
            }
        }

        for (int measure : measureList) {
            System.out.print(measure + " ");
        }
        System.out.print(inputNumber + " ");
    }
}
