package BaekJoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListenTo1764 {

    /**
     * 듣보잡 문제
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNumbers = br.readLine().split(" ");

        int notHeardNumber = Integer.parseInt(inputNumbers[0]);
        int notSeenNumber = Integer.parseInt(inputNumbers[1]);

        Map<String, String> notHeards = new HashMap<>();
        List<String> list = new ArrayList<>();

        String text = "";
        for (int i = 0; i < notHeardNumber; i++) {
            text = br.readLine();
            notHeards.put(text, text);
        }

        for (int i = 0; i < notSeenNumber; i++) {
            text = br.readLine();
            if (notHeards.containsKey(text)) {
                list.add(text);
            }
        }
        list.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (String result : list) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}
