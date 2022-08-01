package BaekJoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PocemonMaster1620 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        /**
         * 나는야 포켓몬 마스터 이다솜 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int pocemonOfNumber = read();
        int testOfNumber = read();

        HashMap<String, Integer> map = new HashMap<>();
        String[] list = new String[pocemonOfNumber];
        
        for (int i = 0; i < pocemonOfNumber; i++) {
            String pocemonName = br.readLine();
            map.put(pocemonName, i + 1);
            list[i] = pocemonName;
        }
        for (int i = 0; i < testOfNumber; i++) {
            String str  = br.readLine();
            char front = str.charAt(0);
            if (front >= '0' && front <= '9') {
                int index = Integer.parseInt(str);
                sb.append(list[index - 1]).append(NEW_LINE);
                continue;
            }
            sb.append(map.get(str)).append(NEW_LINE);
        }

        System.out.println(sb);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
