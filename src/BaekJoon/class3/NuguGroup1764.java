package BaekJoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class NuguGroup1764 {

    public static void main(String[] args) throws IOException {
        /**
         * 듣보잡 문제
         */

        // 듣도 보도 못한 이름 중복인거 반환하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int notHeard = Integer.parseInt(strings[0]);
        int notSeen = Integer.parseInt(strings[1]);

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < notHeard; i++) {
            String name = br.readLine();
            map.put(name, i);
        }
    }
}
