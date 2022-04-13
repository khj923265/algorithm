package jungol.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrincessGarden2461 {
    private static int nextEndMonth;
    private static int nextEndDay;

    static class Period implements Comparable<Period>{
        private final int startMonth;
        private final int startDay;
        private final int endMonth;
        private final int endDay;

        public Period(int startMonth, int startDay, int endMonth, int endDay) {
            this.startMonth = startMonth;
            this.startDay = startDay;
            this.endMonth = endMonth;
            this.endDay = endDay;
        }

        /**
         * 꽃이 피는 날짜를 기준으로 정렬하되 피는 날짜가 같으면 꽃이 지는 날짜를 기준으로 정렬
         */
        @Override
        public int compareTo(Period o) {
            if (startMonth == o.startMonth) {
                if (startDay == o.startDay) {
                    if (endMonth == o.endMonth) {
                        return o.endDay - endDay;
                    }
                    return o.endMonth - endMonth;
                }
                return startDay - o.startDay;
            }
            return startMonth - o.startMonth;
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 공주님의 정원 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Period[] periodList = new Period[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            if (startMonth < 3 ) {
                startMonth = 3;
                startDay = 1;
            }
            if (endMonth == 12) {
                endDay = 1;
            }
            periodList[i] = new Period(startMonth, startDay, endMonth, endDay);
        }

        Arrays.sort(periodList);

        // 3 1 12 1 값이 정렬시 첫번째 값으로 들어올 경우 0이 출력되기 때문에 추가
        if (periodList[0].startMonth == 3 && periodList[0].startDay == 1
                && 11 < periodList[0].endMonth) {
            System.out.println(1);
            return;
        }
        /*if (periodList[0].startMonth < 3 || (periodList[0].startMonth == 3 && periodList[0].startDay != 1)) {
            System.out.println(0);
            return;
        }*/

        int endMonth = periodList[0].endMonth;
        int endDay = periodList[0].endDay;
        nextEndMonth = 1;
        nextEndDay = 1;
        int result = 1;
        int index = 1;

        while (true) {
            if (11 < nextEndMonth) {
                System.out.println(result);
                return;
            }

            index = findNextFlower(N, index, periodList, endMonth, endDay);
            if (index == 0) {
                System.out.println(0);
                return;
            }
            endMonth = nextEndMonth;
            endDay = nextEndDay;
            ++result;
        }

    }

    private static int findNextFlower(int N, int index, Period[] periodList, int endMonth, int endDay) {
        int nextFlowerIndex = 0;
        for (int i = index; i < N; i++) {
            // 최적으로 고른 end 날짜가 다음 찾는 end 날짜보다 크면 의미가 없이 때문에 멈춤
            if (periodList[i].endMonth < endMonth ||
                    (periodList[i].endMonth == endMonth && periodList[i].endDay <= endDay)) {
                continue;
            }
            // 최적으로 고른 end 날짜가 다음 찾는 시작날짜보다 빠르면 의미가 없기때문에 멈춤
            if (endMonth < periodList[i].startMonth ||
                    (endMonth == periodList[i].startMonth && endDay < periodList[i].startDay)) {
                break;
            }
            // 최적으로 고른 end 날짜보다 start 날짜가 빠른 꽃중 end 날짜가 가장 늦는 꽃을 찾는 로직
            if (nextEndMonth == periodList[i].endMonth && nextEndDay < periodList[i].endDay) {
                nextEndDay = periodList[i].endDay;
                nextFlowerIndex = i;
                continue;
            }

            if (nextEndMonth < periodList[i].endMonth) {
                nextEndMonth = periodList[i].endMonth;
                nextEndDay = periodList[i].endDay;
                nextFlowerIndex = i;
            }
        }
        return nextFlowerIndex;
    }
}
