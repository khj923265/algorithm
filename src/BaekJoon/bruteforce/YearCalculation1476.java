package BaekJoon.bruteforce;

public class YearCalculation1476 {

    public static void main(String[] args) throws Exception {
        /**
         *  날짜 계산 문제
         *  지구 = E 태양 = S 달 = M 각각 범위가 다르고 범위를 넘어가면 1로 다시 변경됨
         *  이 3개의 입력값으로 지구년도로 계산해서 출력하기
         */

        int earthYear = read();
        int sunYear = read();
        int moonYear = read();
        int realYear = 1;

        int earthYearCount = 0;
        int sunYearCount = 0;
        int moonYearCount = 0;

        boolean isEnd = true;

        while(isEnd) {
            ++earthYearCount;
            ++sunYearCount;
            ++moonYearCount;

            if (earthYearCount > 15) earthYearCount = 1;
            if (sunYearCount > 28) sunYearCount = 1;
            if (moonYearCount > 19) moonYearCount = 1;

            if (earthYear == earthYearCount && sunYear == sunYearCount && moonYear == moonYearCount) {
                isEnd = false;
            } else {
                ++realYear;
            }
        }

        System.out.println(realYear);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
