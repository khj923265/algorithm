package BaekJoon.bruteforce;

public class YearCalculation1476 {

    public static void main(String[] args) throws Exception {
        /**
         *  날짜 계산 문제
         *  지구 = E 태양 = S 달 = M 각각 범위가 다르고 범위를 넘어가면 1로 다시 변경됨
         *  이 3개의 입력값으로 지구년도로 계산해서 출력하기
         */

        int EarthYear = read();
        int SunYear = read();
        int MoonYear = read();
        int RealYear = 1;

        int EarthYearCount = 0;
        int SunYearCount = 0;
        int MoonYearCount = 0;

        boolean isEnd = true;

        while(isEnd) {
            ++EarthYearCount;
            ++SunYearCount;
            ++MoonYearCount;

            if (EarthYearCount > 15) EarthYearCount = 1;
            if (SunYearCount > 28) SunYearCount = 1;
            if (MoonYearCount > 19) MoonYearCount = 1;

            if (EarthYear == EarthYearCount && SunYear == SunYearCount && MoonYear == MoonYearCount) {
                isEnd = false;
            } else {
                ++RealYear;
            }
        }

        System.out.println(RealYear);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
