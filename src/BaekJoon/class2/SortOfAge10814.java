package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortOfAge10814 {
    private static int numberOfPeople;
    private static List<Member> members;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        /**
         * 나이순 정렬 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        members = new ArrayList<>();
        sb = new StringBuilder();

        numberOfPeople = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] memberInfo = br.readLine().split(" ");
            Member member = new Member(i, Integer.parseInt(memberInfo[0]), memberInfo[1]);
            members.add(member);
        }

        members.stream()
                .sorted(Comparator.comparingInt(Member::getAge).thenComparingInt(Member::getNo))
                .forEach(Member::insertSb);

        System.out.println(sb);


    }

    private static class Member {
        int no;
        int age;
        String name;

        public Member(int no, int age, String name) {
            this.no = no;
            this.age = age;
            this.name = name;
        }

        public static void insertSb(Member member) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        public int getNo() {
            return no;
        }

        public int getAge() {
            return age;
        }
    }
}
