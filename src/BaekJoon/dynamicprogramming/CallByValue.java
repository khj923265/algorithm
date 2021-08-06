package BaekJoon.dynamicprogramming;

public class CallByValue {
    public static void swap(Integer x, Integer y) {
        int temp = 100;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;

        System.out.println("swap() 호출 전 : a = " + a + ", b = " + b);
        swap(a, b);
        System.out.println("swap() 호출 후 : a = " + a + ", b = " + b);

    }

}
