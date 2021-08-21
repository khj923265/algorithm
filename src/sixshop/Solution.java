package sixshop;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] estimates = {5, 1, 9, 8, 10, 5};
        int k = 3;

        int answer = solution.solution(estimates, k);
        System.out.println(answer);
    }

    public int solution(int[] estimates, int k) {
        int[] dp = new int[estimates.length - k + 1];
        int answer = 0;

        for (int i = 0; i < k; i++) {
            dp[0] += estimates[i];
        }

        for (int i = 1; i <= estimates.length - k; i++) {
            dp[i] = dp[i - 1] - estimates[i - 1] + estimates[i + k - 1];
        }

        answer = Arrays.stream(dp).max().getAsInt();

        return answer;
    }

}
