package BaekJoon.dynamicprogramming;

public class ConsecutiveSum13398 {

    public static void main(String[] args) throws Exception {
        /**
         * 연속합 2 문제
         */

        // 배열중 음수인 부분을 타겟으로 잡고 dp를 저장하면 되지않을 까 해서 풀었지만 메모리초과 뜸
        // ex)
        // 10 -4 3 1 5 6 -35 12 21 -1
        // -1 21 12 -35 6 5 1 3 -4 10
        // 1 2 3 4 5 6 7 8 9 10

        // -4 를 기준으로 10 ~ 6 까지
        // -35 를 기준으로 10 ~ 21 까지 했다가 뒷부분에서 음수를 더하고 쭉 갈수도 있어서 끝까지 찾게함

        // 정답확인
        // dp를 거꾸로도 저장해서 앞/뒤 dp를 저장하는 방법이 있었음
        // [10, 6, 9 , 10 ,15 ~]
        // [                  21 ,-1]

        int N = read();

        int[] dp = new int[N];
        int[] arr = new int[N];
        arr[0] = read();
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            int targetValue = read();
            arr[i] = targetValue;
            dp[i] = Math.max(dp[i - 1] + targetValue, targetValue);
            // 정방향 합중 가장 큰 dp를 저장해둠 ( 음수를 삭제하지 않을 수도 있어서 )
            if (dp[i] > max) max = dp[i];
        }

        int[] reverseDp = new int[N];
        reverseDp[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            reverseDp[i] = Math.max(reverseDp[i + 1] + arr[i],arr[i]);
        }

        int temp;
        for (int i = 1; i < N - 1; i++) {
            temp = Math.max(dp[i - 1] + reverseDp[i + 1], max);

            max = Math.max(temp, max);
        }

//        for (int i = 2; i < N; i++) {
//            if (dp[i - 2] > dp[i - 1]) {
//                if (dp[i - 1] > 0) {
//                    for (int j = i; j < N - 1; j++) {
//                        if (dp[j] < dp[j + 1]) {
//                            max = Math.max(dp[i - 2] + dp[j + 1] - dp[i - 1], max);
//                        }
//                    }
//                } else {
//                    for (int j = i; j < N - 1; j++) {
//                        if (dp[j] < dp[j + 1]) {
//                            max = Math.max(dp[i - 2] + dp[j + 1], max);
//                        }
//                    }
//                }
//            }
//        }
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}
