package BaekJoon.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Integer> resultList = new ArrayList<>();
        int resultCount = 0;

        if (96 < targetChannel && targetChannel < 104) {
            if (targetChannel < 100) {
                System.out.println(100 - targetChannel);
                return;
            } else if (targetChannel > 100) {
                System.out.println(targetChannel - 100);
                return;
            }else {
                System.out.println(0);
                return;
            }
        }

        // 리스트에 고장난 번호 담기
        for (int i = 0; i < brokenButtonCount; i++) {
            brokenNumberList.add(read());
        }

        int targetChannelCopy = targetChannel;
        // 리스트에 타겟채널
        while(targetChannelCopy > 0) {
            targetChannelList.add(targetChannelCopy%10);
            targetChannelCopy /= 10;
        }
        Collections.reverse(targetChannelList);

        if (brokenButtonCount == 0) {
            System.out.println(targetChannelList.size());
            return;
        }

        resultCount = getResultCountBySelectNumber(brokenNumberList, targetChannelList, resultList, resultCount);

        int result = 0;
        for (int i = 0; i < resultList.size(); i++) {
            result += resultList.get(i);
            if (!(i == resultList.size() - 1)) {
                result *= 10;
            }
        }

        if (result < targetChannel) {
            while (result < targetChannel) {
                ++result;
                ++resultCount;
            }
        } else if (result > targetChannel){
            while (result > targetChannel) {
                --result;
                ++resultCount;
            }
        }
        System.out.println(resultCount);

    }

    private static int getResultCountBySelectNumber(List<Integer> brokenNumberList,
        List<Integer> targetChannelList, List<Integer> resultList, int resultCount) {
        int channelDigit = targetChannelList.size();

        for (int i = 0; i < channelDigit; i++) {
            if (brokenNumberList.contains(targetChannelList.get(i))) {
                int highIndex = getHighIndex(brokenNumberList, targetChannelList, i);
                int lowIndex = getLowIndex(brokenNumberList, targetChannelList, i);
                if (!(highIndex == 100 && lowIndex == -100)) {
                    if (highIndex - targetChannelList.get(i) < targetChannelList.get(i) - lowIndex) {
                        resultCount = channelDigit;
                        resultList.add(highIndex);
                    } else {
                        resultCount = channelDigit;
                        resultList.add(lowIndex);
                    }
                }
            } else {
                resultList.add(targetChannelList.get(i));
            }
        }
        return resultCount;
    }

    private static int getHighIndex(List<Integer> brokenNumberList, List<Integer> targetChannelList, int i) {
        int forIndex = 10 - targetChannelList.get(i);
        for (int j = 1; j < forIndex; j++) {
            if (!brokenNumberList.contains(targetChannelList.get(i) + j)) {
                return targetChannelList.get(i) + j;
            }
        }
        return 100;
    }

    private static int getLowIndex(List<Integer> brokenNumberList, List<Integer> targetChannelList, int i) {
        int forIndex = targetChannelList.get(i) + 1;
        for (int j = 1; j < forIndex; j++) {
            if (!brokenNumberList.contains(targetChannelList.get(i) - j)) {
                return targetChannelList.get(i) + j;
            }
        }
        return -100;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
