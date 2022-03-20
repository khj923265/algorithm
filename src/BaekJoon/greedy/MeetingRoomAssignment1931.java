package BaekJoon.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingRoomAssignment1931 {
    private static int[][] scheduleList;
    private static int maxCount;
    private static int previousScheduleEndTime;

    public static void main(String[] args) throws Exception {
        /**
         * 회의실 배정 문제
         */
        
        int N = read();

        scheduleList = new int[N][2];
        maxCount = 1;

        for (int i = 0; i < N; i++) {
            scheduleList[i][0] = read();
            scheduleList[i][1] = read();
        }

        List<int[]> sortedScheduleList = Arrays.stream(scheduleList)
                .sorted((o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return Integer.compare(o1[0], o2[0]);
                    } else {
                        return Integer.compare(o1[1], o2[1]);
                    }
                }).collect(Collectors.toList());

        previousScheduleEndTime = sortedScheduleList.get(0)[1];

        for (int i = 1; i < N; i++) {
            if (previousScheduleEndTime <= sortedScheduleList.get(i)[0]) {
                ++maxCount;
                previousScheduleEndTime = sortedScheduleList.get(i)[1];
            }
        }

        System.out.println(maxCount);
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
