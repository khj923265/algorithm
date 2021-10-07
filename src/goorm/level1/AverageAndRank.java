package goorm.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AverageAndRank {

    public static void main(String[] args) throws Exception {
        /**
         * 시험성적 평균과 등급 구하기
         * 시험성적의 평균을 구하고 평균 점수에 따라 등급을 적용
         * ex)
         * 80 70 90
         * 80 B
         */
        //TODO 평균이 100일 경우 100.0 으로 둘째자리가 짤림 해결해야함!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringNumber = br.readLine();
        String[] stringNumberList = stringNumber.split(" ");
        double sum = 0;

        for (String number : stringNumberList) {
            double doubleNumber = Double.parseDouble(number);
            sum += doubleNumber;
        }
        double average = sum / 3;
        double result = (double)Math.round(average*100)/100;
        if (result >= 90) {
            System.out.println(result + " A");
        } else if (result >= 80) {
            System.out.println(result + " B");
        } else if (result >= 70) {
            System.out.println(result + " C");
        } else if (result >= 60) {
            System.out.println(result + " D");
        } else {
            System.out.println(result + " F");
        }
    }

}
