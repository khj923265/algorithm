package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bulk7568 {

    public static void main(String[] args) throws IOException {
        /**
         * 덩치 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        int N = Integer.parseInt(br.readLine().trim());
        int height;
        int weight;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            height = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            students.add(new Student(height, weight));
        }

        for (Student student : students) {
            for (Student student1 : students) {
                if (student != student1) {
                    if (student.weight < student1.weight && student.height < student1.height) {
                        student.count = student.count + 1;
                    }
                }
            }
        }

        students.forEach(i -> System.out.print(1 + i.count + " "));

    }

    private static class Student{
        int height;
        int weight;
        int count;

        public Student(int height, int weight) {
            this.height = height;
            this.weight = weight;
            this.count = 0;
        }
    }
}
