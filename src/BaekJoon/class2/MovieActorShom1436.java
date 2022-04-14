package BaekJoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieActorShom1436 {

    public static void main(String[] args) throws IOException {
        /**
         * 영화감독 숌 문제 (소수 관련)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String filmTitle = "666";
        int count = 0;

        while (true) {
            if (filmTitle.contains("666")) {
                ++count;
            }
            if (N == count) {
                System.out.println(filmTitle);
                return;
            }
            filmTitle = Integer.toString(Integer.parseInt(filmTitle) + 1);

        }
    }
}
