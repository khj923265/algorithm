package rbstudy.one;

import java.util.ArrayList;

public class MainRb_JS2 {

    // 이름 정렬 후 점수 계산, 점수기준 정렬
    // and then 동점자 랭크처리, 리스트에 동점자 담기

    private static float SCORE_LEVEL_1 = (float) 0.1;
    private static float SCORE_LEVEL_2 = (float) 0.11;
    private static float SCORE_LEVEL_3 = (float) 0.15;

    // 가산점 부여
    public static void setAddScore(Student eo) {
        int totalScore = 0;
        float addScore = 0;
        if(eo.getLevel() == 1) {
            addScore = (float)eo.getScore() * SCORE_LEVEL_1;
        }
        else if(eo.getLevel() == 2) {
            addScore = (float)eo.getScore() * SCORE_LEVEL_2;
        }
        else if(eo.getLevel() == 3) {
            addScore = (float)eo.getScore() * SCORE_LEVEL_3;
        }
        totalScore = (int)(eo.getScore() + addScore);

        eo.setTotalScore(totalScore);
        eo.setAddScore(addScore);
    }

    // 이름 내림차순 정렬
    public static void descendingName(ArrayList<Student> eo) {
        for(int i=0; i<eo.size(); i++){
            Student temp;
            for(int j=i+1; j<eo.size(); j++){
                if(eo.get(i).getName().compareTo(eo.get(j).getName()) > 0){
                    temp = eo.get(i);
                    eo.set(i, eo.get(j));
                    eo.set(j, temp);
                }
            }
        }
    }

    // 총점 내림차순 정렬
    public static void descendingTtScore(ArrayList<Student> eo) {
        for(int i=0; i<eo.size(); i++){
            Student temp;
            for(int j=i+1; j<eo.size(); j++){
                if(eo.get(i).getTotalScore() < eo.get(j).getTotalScore()){
                    temp = eo.get(i);
                    eo.set(i, eo.get(j));
                    eo.set(j, temp);
                }
            }
            eo.get(i).setRank(eo.get(i).getRank() + i);
        }
    }

    // 동점자 처리
    public static void solSameScore(ArrayList<Student> eo, ArrayList<Student> rdp) {

        // 동점자 랭크 처리
        for(int i=0; i<eo.size()-1; i++){
            if(eo.get(i).getTotalScore() == eo.get(i+1).getTotalScore()){
                eo.get(i+1).setRank(eo.get(i).getRank());
            }
        }

        // 동점자들만 중복없이 List에 저장
        for(int i=0; i<eo.size(); i++){
            for(int j=i+1; j<eo.size(); j++){
                if(eo.get(i).getTotalScore() == eo.get(j).getTotalScore()){
                    if(!rdp.contains(eo.get(i))){
                        rdp.add(eo.get(i));
                    }
                    if(!rdp.contains(eo.get(j))){
                        rdp.add(eo.get(j));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
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

        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Student> rdpStudents = new ArrayList<>();

        Student s1 = new Student();
        s1.setName("김종신1");
        s1.setScore(69);
        s1.setLevel(2);
        MainRb_JS2.setAddScore(s1);
        studentList.add(s1);

        Student s2 = new Student();
        s2.setName("김종신2");
        s2.setScore(34);
        s2.setLevel(1);
        MainRb_JS2.setAddScore(s2);
        studentList.add(s2);

        Student s3 = new Student();
        s3.setName("김종신3");
        s3.setScore(87);
        s3.setLevel(2);
        MainRb_JS2.setAddScore(s3);
        studentList.add(s3);

        Student s4 = new Student();
        s4.setName("김종신4");
        s4.setScore(97);
        s4.setLevel(3);
        MainRb_JS2.setAddScore(s4);
        studentList.add(s4);

        Student s5 = new Student();
        s5.setName("마구니");
        s5.setScore(89);
        s5.setLevel(2);
        MainRb_JS2.setAddScore(s5);
        studentList.add(s5);

        Student s6 = new Student();
        s6.setName("바구니");
        s6.setScore(86);
        s6.setLevel(3);
        MainRb_JS2.setAddScore(s6);
        studentList.add(s6);

        // 이름 정렬 메소드
        descendingName(studentList);

        // 점수 정렬 메소드
        descendingTtScore(studentList);

        // 동점자 처리 메소드
        solSameScore(studentList, rdpStudents);

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getRank() + "순위 " + studentList.get(i).getName() + " " + studentList.get(i).getTotalScore() + " " + studentList.get(i).getLevel());
        }

        System.out.println("\n동일점수자, 총 " + rdpStudents.size() + "명");
        for (int i = 0; i < rdpStudents.size(); i++) {
            System.out.println(rdpStudents.get(i).getRank() + "순위 " + rdpStudents.get(i).getName() + " " + rdpStudents.get(i).getTotalScore() + " " + rdpStudents.get(i).getLevel());
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
            private String name;
            private int level, score, addScore, totalScore, rank=1;

            public void setName(String name){
                this.name = name;
            }
            public String getName(){
                return name;
            }

            public void setLevel(int level){
                this.level = level;
            }
            public int getLevel(){
                return level;
            }

            public void setScore(int score) { this.score = score; }
            public int getScore() { return score; }

            public void setAddScore(float addScore) { this.addScore = (int) addScore; }
            public int getAddScore() { return addScore; }

            public void setTotalScore(int totalScore) { this.totalScore = totalScore; }
            public int getTotalScore() { return totalScore; }

            public void setRank(int rank) { this.rank = rank; }
            public int getRank() { return rank; }

            /*
             * 문자열 : name
             * 숫자형 : level(레벨) , score(기본점수), addScore(가산점수), totalScore(기본+가산점수), rank(순위)
             * 자료 구조를 만듦
             * hint : s / g
             * */
        }
}
