package BaekJoon.practice;

import java.util.Scanner;

public class APlusB10951 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNext()) {
            sb.append(sc.nextInt() + sc.nextInt()).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}