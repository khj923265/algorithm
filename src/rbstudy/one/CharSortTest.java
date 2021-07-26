package rbstudy.one;

import java.util.ArrayList;
import java.util.List;
import rbstudy.one.MainRb.Student;

public class CharSortTest {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        student1.setName("박지원");
        student1.setScore(69);
        student1.setLevel(2);
        student2.setName("최종인");
        student2.setScore(34);
        student2.setLevel(1);
        student3.setName("조현호");
        student3.setScore(87);
        student3.setLevel(2);
        student4.setName("김형준");
        student4.setScore(97);
        student4.setLevel(3);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        for (Student student : studentList){
            System.out.println(student.getRank() + "순위 이름: " + student.getName()
                + " 총점: " + student.getTotalScore() + " 레벨: " + student.getLevel());
        }

        for(int i = 1; i < studentList.size(); i++) {
            Student targetStudent = studentList.get(i);
            int j = i - 1;

            char[] targetChars = targetStudent.getName().toCharArray();
            char[] chars = studentList.get(j).getName().toCharArray();

            while(j >= 0 && targetChars[0] < chars[0]) {
                studentList.set(j + 1, studentList.get(j));
                j--;
            }
            studentList.set(j + 1, targetStudent);
        }

        for (Student student : studentList){
            System.out.println(student.getRank() + "순위 이름: " + student.getName()
                + " 총점: " + student.getTotalScore() + " 레벨: " + student.getLevel());
        }

        isSyllableSort("김형준","마구니");



    }

    private static int[] getSyllableIndexList(String text) {
        int[] syllableIndexList = new int[3];

        if(text.length() > 0) {
            char charName = text.charAt(0);
            if(charName >= 0xAC00) {
                int uniIndex = charName - 0xAC00;
                System.out.println("uniIndex : " + uniIndex);
                int onsetIndex = ((uniIndex - (uniIndex % 28))/28)/21;
                int nucleusIndex = (uniIndex / 28) % 21;
                int codaIndex = uniIndex % 28;
                syllableIndexList[0] = onsetIndex;
                syllableIndexList[1] = nucleusIndex;
                syllableIndexList[2] = codaIndex;
                return syllableIndexList;
            }
        }

        return syllableIndexList;
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
                    if (onsetIndex1 > onsetIndex2) return false;
                    if (onsetIndex1 < onsetIndex2) return true;

                    int nucleusIndex1 = (uniIndex1 / 28) % 21;
                    int nucleusIndex2 = (uniIndex2 / 28) % 21;
                    if (nucleusIndex1 > nucleusIndex2) return false;
                    if (nucleusIndex1 < nucleusIndex2) return true;

                    int codaIndex1 = uniIndex1 % 28;
                    int codaIndex2 = uniIndex2 % 28;
                    if (codaIndex1 > codaIndex2) return false;
                    if (codaIndex1 < codaIndex2) return true;
                }
            }
        }
        return true;
    }

}
