package study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainRb {

    public static void main(String[] args){
        //TODO
    // 학생 4 명이 있다.
    // 김종신1 : score(69) level(2)
    // 김종신2 : score(34) level(1)
    // 김종신3 : score(87) level(2)
    // 김종신4 : score(97) level(3)
    // 각 학생의 기본 데이터를 저장할 자료구조 클래스를 만든다.
    // 이를 기본으로  위의 자료구조 데이터를  리스트에 담는다

    // 위의 데이터 기준으로 아래 가점 항목을 계산해서 데이터 반영 후
    // 레벨 1 의 가점 10% /  레벨 2의 가점 11% / 레벨 3의 가점 15%

    // 가장 점수가 높은 순으로 순위를 매긴다.
    // 순위가 정해지면 이를 높은 순위 부터 정렬해서 출력합니다.
    // 출력형식
        /**
         *
         순위 이름 총점 레벨 순으로 출력
         ex )
         1순위 김종신1 69 2
         2순위 김종신1 69 2
         3순위 김종신1 69 2
         4순위 김종신1 69 2
         *
         */

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("김형준1", 69, 2));
        studentList.add(new Student("김형준2", 34, 1));
        studentList.add(new Student("김형준3", 87, 2));
        studentList.add(new Student("김형준4", 97, 3));

        for (Student student : studentList){
            student.insertAddScore(student.level, student.score);
            student.insertTotalScore(student.score, student.addScore);
        }

        for (int i = 0; i < studentList.size(); i++){
            studentList.get(i).setRank(1);
            for (Student student : studentList) {
                if (studentList.get(i).getTotalScore() < student.getTotalScore())
                    studentList.get(i).updateRankCount();
            }
        }

        studentList.stream()
                .sorted(Comparator.comparingInt(Student::getRank))
                .forEach(student -> {
                    System.out.println(student.rank + "순위 " + student.name + " " + student.totalScore + " " + student.level);
                });
    }

    static class Student{
        private String name;
        private int level;
        private int score;
        private int addScore;
        private int totalScore;
        private int rank;

        Student (String name, int score, int level){
            this.name = name;
            this.score = score;
            this.level = level;
        }

        void insertAddScore(int level, int score){
            if (level == 1) {
                this.addScore = (int) (score * 0.1);
            } else if (level == 2) {
                this.addScore = (int) (score * 0.11);
            } else if (level == 3) {
                this.addScore = (int) (score * 0.15);
            }
        }

        void insertTotalScore(int score, int addScore){
            this.totalScore = score + addScore;
        }

        void updateRankCount(){
            this.rank++;
        }

        public int getTotalScore() {
            return totalScore;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        /*
        * 문자열 : name
        * 숫자형 : level(레벨) , score(기본점수), addScore(가산점수), totalScore(기본+가산점수), rank(순위)
        * 자료 구조를 만듦
        * hint : s / g
        * */
    }

}
