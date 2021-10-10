package goorm.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shift {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);

        System.out.println(a >> b);
        System.out.print(a << b);
    }

}
