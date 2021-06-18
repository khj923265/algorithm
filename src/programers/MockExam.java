package programers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MockExam {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        int[] answers = {1,3,2,4,2};

        System.out.println(Arrays.toString(MockExam.solution(answers)));

    }

    public static int[] solution(int[] answers) {
        int[] firstStudent = {1, 2, 3, 4, 5};
        int[] secondStudent = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdStudent = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstStudentScore = 0;
        int secondStudentScore = 0;
        int thirdStudentScore = 0;
        int count  = 0;
        int[] an;

        for (int answer : answers) {
            if (count == 5) {
                count = 0;
            }
            if (answer == firstStudent[count]) {
                firstStudentScore++;
            }
            count++;
        }
        count = 0;
        for (int answer : answers) {
            if (count == 8) {
                count = 0;
            }
            if (answer == secondStudent[count]) {
                secondStudentScore++;
            }
            count++;
        }
        count = 0;
        for (int answer : answers) {
            if (count == 10) {
                count = 0;
            }
            if (answer == thirdStudent[count]) {
                thirdStudentScore++;
            }
            count++;
        }

        if (firstStudentScore > secondStudentScore){
            if (firstStudentScore > thirdStudentScore){
                an = new int[] {1};
                return an;
            }else if (firstStudentScore == thirdStudentScore){
                an = new int[] {1,3};
                return an;
            }else {
                an = new int[] {3};
                return an;
            }
        }else if(firstStudentScore < secondStudentScore){
            if (secondStudentScore > thirdStudentScore){
                an = new int[] {2};
                return an;
            }else if (secondStudentScore == thirdStudentScore){
                an = new int[] {2,3};
                return an;
            }else {
                an = new int[] {3};
                return an;
            }
        }else{
            if (firstStudentScore > thirdStudentScore){
                an = new int[] {1,2};
                return an;
            }else if (firstStudentScore == thirdStudentScore){
                an = new int[] {1,2,3};
                return an;
            }else {
                an = new int[] {3};
                return an;
            }
        }


    }


}
