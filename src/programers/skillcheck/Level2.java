package programers.skillcheck;

import java.util.HashSet;
import java.util.Set;

public class Level2 {

    public static void main(String[] args) {
        String s = "011";
        solution(s);
    }

    // 주식 몇초동안 안떨어졌는지 구하기
    public static int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i] || j == prices.length - 1) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        answer[prices.length - 1] = 0;
        return answer;
    }

    // 만들 수 있는 소수 갯수 구하기
    public static int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        combination(numbers, "", set);

        for (int num : set) {
            if (isPrimeNumber(num)) {
                answer = answer + 1;
            }
        }

        return answer;
    }

    // 소수 공식
    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number %i == 0) return false;
        }
        return true;
    }

    public static void combination(String numbers, String str, Set<Integer> set) {
        int phoneLength = numbers.length();
        if (!"".equals(str)) {
            set.add(Integer.valueOf(str));
        }
        for (int i = 0; i < phoneLength; i++) {
            combination(numbers.substring(0, i) + numbers.substring(i + 1, phoneLength),
                    str + numbers.charAt(i), set);
        }
    }
}
