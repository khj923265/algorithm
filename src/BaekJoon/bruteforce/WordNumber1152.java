package BaekJoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordNumber1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wordArr = br.readLine().split(" ");

        if (wordArr.length != 0) {
            if ("".equals(wordArr[0])) {
                System.out.println(wordArr.length - 1);
            } else {
                System.out.println(wordArr.length);
            }
        } else {
            System.out.println(0);
        }

    }
}
