package rbstudy.one;

import java.util.ArrayList;
import java.util.List;

public class MainRb {

    public static void main(String[] args){
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
    // TODO 소스코드 수정 후 순위가 출력된 상태에서 추가작업
    // 전학생 마구니1 score(76) level(2)
    // 전학생 바구니2 score(87) level(3)
    // 동일 점수 일 경우 이름을 기준으로 descending sort(내림차순) 해서 순위를 매김
    // 동일점수 인원이 몇명인지 출력 후 누구누구인지도 출력
        /**
         * ex)
         * 총 2명
         * 2순위 마구니 100 2
         * 2순위 바구니 100 3
         */

        List<Student> studentList = new ArrayList<>();
        StudentScoreCalculateUtil studentScoreCalculateUtil = new StudentScoreCalculateUtil();
        StudentRankCalculateUtil studentRankCalculateUtil = new StudentRankCalculateUtil();

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        student1.setName("김형준1");
        student1.setScore(69);
        student1.setLevel(2);
        student2.setName("김형준2");
        student2.setScore(34);
        student2.setLevel(1);
        student3.setName("김형준3");
        student3.setScore(87);
        student3.setLevel(2);
        student4.setName("김형준4");
        student4.setScore(97);
        student4.setLevel(3);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        for (Student student : studentList){
            studentScoreCalculateUtil.insertAddScore(student);
            studentScoreCalculateUtil.insertTotalScore(student);
        }

        studentRankCalculateUtil.updateStudentsRank(studentList, studentRankCalculateUtil);

        studentRankCalculateUtil.studentRankSortPrint(studentList);

        Student student5 = new Student();
        Student student6 = new Student();
        student5.setName("마구니1");
        student5.setScore(87);
        student5.setLevel(3);
        student6.setName("바구니1");
        student6.setScore(87);
        student6.setLevel(3);

        studentScoreCalculateUtil.insertAddScore(student5);
        studentScoreCalculateUtil.insertTotalScore(student5);
        studentScoreCalculateUtil.insertAddScore(student6);
        studentScoreCalculateUtil.insertTotalScore(student6);
        studentList.add(student5);
        studentList.add(student6);

        studentRankCalculateUtil.updateStudentsRank(studentList, studentRankCalculateUtil);

        studentRankCalculateUtil.studentRankSortPrint(studentList);

    }

    static class Student{
        private String name;
        private int level;
        private int score;
        private int addScore;
        private int totalScore;
        private int rank;

        Student (){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getAddScore() {
            return addScore;
        }

        public void setAddScore(int addScore) {
            this.addScore = addScore;
        }

        public int getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(int totalScore) {
            this.totalScore = totalScore;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
        /*
        * 문자열 : name
        * 숫자형 : level(레벨) , score(기본점수), addScore(가산점수), totalScore(기본+가산점수), rank(순위)
        * 자료 구조를 만듦
        * hint : s / g
        * */
    }

    static class StudentScoreCalculateUtil{

        void insertAddScore(Student student){
            if (student.getLevel() == 1) {
                student.setAddScore((int)(student.getScore() * 0.1));
            } else if (student.getLevel() == 2) {
                student.setAddScore((int)(student.getScore() * 0.11));
            } else if (student.getLevel() == 3) {
                student.setAddScore((int)(student.getScore() * 0.15));
            }
        }

        void insertTotalScore(Student student){
            student.setTotalScore(student.getScore() + student.getAddScore());
        }

    }

    static class StudentRankCalculateUtil{

        void updateRankCount(Student student){
            student.setRank(student.getRank() + 1);
        }

        void updateStudentsRank(List<Student> studentList, StudentRankCalculateUtil studentRankCalculateUtil) {
            for (int i = 0; i < studentList.size(); i++) {
                studentList.get(i).setRank(1);
                for (Student student : studentList) {
                    if (studentList.get(i).getTotalScore() < student.getTotalScore()) {
                        studentRankCalculateUtil.updateRankCount(studentList.get(i));
                    }
                }
            }
        }

        void studentRankSortPrint(List<Student> studentList) {
            for (int i = 0; i < studentList.size(); i++) {
                for (Student student : studentList) {
                    if (student.getRank() == i + 1) {
                        System.out.println(student.getRank() + "순위 "
                                + student.getName() + " " + student.getTotalScore()
                                + " " + student.getLevel());
                    }
                }
            }
        }

    }

}
