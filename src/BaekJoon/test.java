package BaekJoon;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str.charAt(0));

        switch (str.substring(0,1)) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            case "g":
                System.out.println("g");
                break;
            default:
                System.out.println("de");
                break;
        }
    }

}
