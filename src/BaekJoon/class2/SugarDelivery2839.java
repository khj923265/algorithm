package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery2839 {

    public static void main(String[] args) throws IOException {
        /**
         *  설탕배달 문제
         *  조금 무식하게 푼것같은데?ㅋㅋㅋ
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int result = -1;

        int fiveMod = sugar%5;
        if (sugar%3 == 0) result = sugar/3;
        for (int i = 1; i < sugar/5; i++) {
            if ((sugar - 5*i)%3 == 0) {
                result = i + (sugar - 5*i)/3;
            }
        }
        if (fiveMod%3 == 0) result = sugar/5 + fiveMod/3;
        if (fiveMod == 0) result = sugar/5;

        System.out.println(result);
    }
}
