package BaekJoon.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl1107 {
    public static void main(String[] args) throws Exception {
        /**
         *  리모컨 문제
         *  0 ~ 9, +, - 버튼들이 있고 숫자 버튼중에는 고장난 버튼이 있다.
         *  현재 채널이 100번이고 고장난 버튼이 주어질 때
         *  채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하기.
         */

        //TODO 10/24 같이 풀기
        int currentChannel = 100;
        int targetChannel = read();
        int brokenButtonCount = read();
        List<Integer> brokenNumberList = new ArrayList<>();
        List<Integer> targetChannelList = new ArrayList<>();

        // 리스트에 고장난 번호 담기
        for (int i = 0; i < brokenButtonCount; i++) {
            brokenNumberList.add(read());
        }

        // 리스트에 타겟채널
        while(targetChannel > 0) {
            targetChannelList.add(targetChannel%10);
            targetChannel /= 10;
        }
        System.out.println(brokenNumberList);
        System.out.println(targetChannelList);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
