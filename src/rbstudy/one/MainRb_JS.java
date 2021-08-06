package rbstudy.one;

import java.util.ArrayList;

public class MainRb_JS {

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

        Student s1 = new Student("김종신1", 69, 2);
        Student s2 = new Student("김종신2", 34, 1);
        Student s3 = new Student("김종신3", 87, 2);
        Student s4 = new Student("김종신4", 97, 3);

        ArrayList<Student> students = new ArrayList<>();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        for(int i=0; i<4; i++){
            Student temp = new Student("", 0, 0);
            for(int j=1+i; j<4; j++){
                if(students.get(i).totalScore < students.get(j).totalScore){
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        for(int i=0; i<4; i++){
            System.out.println((i+1)+"순위 "+students.get(i).name+" "+students.get(i).totalScore+" "+students.get(i).level);
        }

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
    }

    static class Student{
        String name;
        int level, score, totalScore, rank;
        float addScore;
        Student(String name, int score, int level){

            // 정보 저장
            this.name = name;
            this.score = score;
            this.level = level;

            // level별 가산점 부여
            if(level == 1) {
                this.addScore = (float) 0.1;
            }
            else if(level == 2) {
                this.addScore = (float) 0.11;
            }
            else if(level == 3) {
                this.addScore = (float) 0.15;
            }

            this.totalScore = (int) (this.score + (this.score * this.addScore));
        }
        /*
         * 문자열 : name
         * 숫자형 : level(레벨) , score(기본점수), addScore(가산점수), totalScore(기본+가산점수), rank(순위)
         * 자료 구조를 만듦
         * hint : s / g
         * */
    }
}
