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
    // 소스코드 수정 후 순위가 출력된 상태에서 추가작업
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
        /**
         * 최종 피드백!!!
         * 1. for문 안에서 studentList.size() 는 직관적이지 않고,
         * null이 올수 있으니 따로 관리해주는 게 좋다.
         * 2. while문 사용은 지양 (데이터 하나 삑나면 무한루프에 빠져서 CPU 점유율 작살남!)
         * for문으로 최대한 해결하고 아니라면 재귀적으로 해결해보자
         * 3. for문과 stream 사용의 차이점 공부해보자! for문이 더 좋을 경우도 있다!
         * 4. 스켈레톤 코드가 무엇인지 찾아보자!!
         */

        List<Student> studentList = new ArrayList<>();

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
        student3.setLevel(3);
        student4.setName("김형준4");
        student4.setScore(97);
        student4.setLevel(3);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        for (Student student : studentList){
            insertAddScore(student);
            insertTotalScore(student);
        }

        sortTotalScore(studentList);
        insertRank(studentList);

        System.out.println("===========학생 총점기준 순위 리스트 v1.0===========");
        printStudentList(studentList);

        Student student5 = new Student();
        Student student6 = new Student();
        Student student7 = new Student();
        student5.setName("마구니1");
        student5.setScore(87);
        student5.setLevel(3);
        student6.setName("바구니1");
        student6.setScore(87);
        student6.setLevel(3);
        student7.setName("마우니1");
        student7.setScore(87);
        student7.setLevel(3);

        insertAddScore(student5);
        insertTotalScore(student5);
        insertAddScore(student6);
        insertTotalScore(student6);
        insertAddScore(student7);
        insertTotalScore(student7);

        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student5);
        studentList.add(student2);
        studentList.add(student7);

        sortTotalScore(studentList);
        insertRank(studentList);
        sortDecsTiedRankByName(studentList);

        System.out.println("===============학생 추가 후 재정렬===============");
        printStudentList(studentList);

        System.out.println("==================동점자 리스트==================");
        printStudentListTiedRank(studentList);
    }

    private static void printStudentListTiedRank(List<Student> studentList) {
        List<Student> tiedRankStudentList = new ArrayList<>();

        for (int i = 0; i < studentList.size() - 1; i++){
            if (studentList.get(i).getRank() == studentList.get(i + 1).getRank()){
                int j = i + 1;
                tiedRankStudentList.add(studentList.get(i));
                    while (studentList.get(i).getRank() == studentList.get(j).getRank()){
                        tiedRankStudentList.add(studentList.get(j));
                        if (j == studentList.size() - 1){
                            break;
                        }
                        j++;
                    }
                System.out.println("총 " + tiedRankStudentList.size() + "명");
                printStudentList(tiedRankStudentList);
                tiedRankStudentList.clear();
                i += j - 1;
            }
        }
    }

    private static void printStudentList(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student.getRank() + "순위 이름: " + student.getName()
                + " 총점: " + student.getTotalScore() + " 레벨: " + student.getLevel());
        }
    }

    private static boolean isSyllableSort(String targetText, String text) {
        int minTextLength = Math.min(targetText.length(), text.length());

        if(minTextLength > 0) {
            for (int i = 0; i < minTextLength; i++) {
                char charName1 = targetText.charAt(i);
                char charName2 = text.charAt(i);
                if (charName1 != charName2) {
                    int uniIndex1 = charName1 - 0xAC00;
                    int uniIndex2 = charName2 - 0xAC00;

                    int onsetIndex1 = ((uniIndex1 - (uniIndex1 % 28))/28)/21;
                    int onsetIndex2 = ((uniIndex2 - (uniIndex2 % 28))/28)/21;
                    if (onsetIndex1 > onsetIndex2) return true;
                    if (onsetIndex1 < onsetIndex2) return false;

                    int nucleusIndex1 = (uniIndex1 / 28) % 21;
                    int nucleusIndex2 = (uniIndex2 / 28) % 21;
                    if (nucleusIndex1 > nucleusIndex2) return true;
                    if (nucleusIndex1 < nucleusIndex2) return false;

                    int codaIndex1 = uniIndex1 % 28;
                    int codaIndex2 = uniIndex2 % 28;
                    if (codaIndex1 > codaIndex2) return true;
                    if (codaIndex1 < codaIndex2) return false;
                }
            }
        }
        return false;
    }

    private static void insertAddScore(Student student){
        if (student.getLevel() == 1) {
            student.setAddScore((int)(student.getScore() * 0.1));
        } else if (student.getLevel() == 2) {
            student.setAddScore((int)(student.getScore() * 0.11));
        } else if (student.getLevel() == 3) {
            student.setAddScore((int)(student.getScore() * 0.15));
        }
    }

    private static void insertTotalScore(Student student){
        student.setTotalScore(student.getScore() + student.getAddScore());
    }

    private static void sortTotalScore(List<Student> studentList){
        for(int i = 1; i < studentList.size(); i++) {
            Student targetStudent = studentList.get(i);
            int j = i - 1;

            while(j >= 0 && targetStudent.getTotalScore() > studentList.get(j).getTotalScore()) {
                studentList.set(j + 1, studentList.get(j));
                j--;
            }
            studentList.set(j + 1, targetStudent);
        }
    }

    private static void insertRank(List<Student> studentList) {
        int count = 1;
        studentList.get(0).setRank(1);
        for(int i = 1; i < studentList.size(); i++){
            if (studentList.get(i).getTotalScore() == studentList.get(i - 1).getTotalScore()){
                studentList.get(i).setRank(count);
            } else {
                studentList.get(i).setRank(++count);
            }
        }
    }

    private static void sortDecsTiedRankByName(List<Student> studentList){
        for(int i = 1; i < studentList.size(); i++) {
            if (studentList.get(i).getRank() == studentList.get(i - 1).getRank()) {
                Student targetStudent = studentList.get(i);
                int j = i - 1;

                while (j >= 0 && isSyllableSort(targetStudent.getName(),studentList.get(j).getName())
                        && targetStudent.getRank() == studentList.get(j).getRank()) {
                    studentList.set(j + 1, studentList.get(j));
                    j--;
                }
                studentList.set(j + 1, targetStudent);
            }
        }
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
}
