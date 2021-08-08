package BaekJoon.dynamicprogramming;

public class Test {

    public static void main(String[] args) {
        char[] string = {'H','e',' ','i','s',' ','g','a','y'};

//        revers(string);

        int result = factorial(5);
        System.out.println(result);
    }

    public static void revers(char[] string) {
        String test = String.valueOf(string);
        String[] testList = test.split(" ");

        for (int i = testList.length - 1; i >= 0; i--) {
            System.out.print(testList[i] + " ");
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
