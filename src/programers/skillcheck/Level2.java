package programers.skillcheck;

import java.util.HashSet;
import java.util.Set;

public class Level2 {

    public static void main(String[] args) {

    }

    // 선행스킬 문제
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skills = skill.toCharArray();
        int maxIndex;

        LOOP1:
        for (String skill_tree : skill_trees) {
            char[] skillTrees = skill_tree.toCharArray();
            maxIndex = 0;
            for (char skillName : skills) {
                for (int j = 0; j < skillTrees.length; j++) {
                    if (skillName == skillTrees[j]) {
                        if (j < maxIndex) {
                            continue LOOP1;
                        }
                        maxIndex = j;
                        break;
                    }
                    if (j == skillTrees.length - 1) {
                        maxIndex = Integer.MAX_VALUE;
                    }
                }
            }
            answer = answer + 1;
        }
        return answer;
    }

    // 최소값과 최대값
    public static String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String str : strings) {
            max = Math.max(max, Integer.parseInt(str));
            min = Math.min(min, Integer.parseInt(str));
        }

        answer = min + " " + max;

        return answer;
    }

    // 삼각달팽이
    // 아래로 + 오른쪽 + 왼쪽대각선 위
    public static int[] solution(int n) {
        int[] answer = {};
        int[][] box = new int[n][n];

        int row = 0;
        int col = 0;
        box[row][col] = 1;
        int count = 2;
        int max = n * (n + 1) / 2;
        while (count <= max) {

            // 아래로
            while (row + 1 < n && box[row + 1][col] == 0) {
                box[row + 1][col] = count;
                count = count + 1;
                row = row + 1;
            }

            // 오른쪽
            while (col + 1 < n && box[row][col + 1] == 0) {
                box[row][col + 1] = count;
                count = count + 1;
                col = col + 1;
            }

            // 왼쪽대각선 위
            while (0 < row - 1 && 0 < col - 1 && box[row - 1][col - 1] == 0) {
                box[row - 1][col - 1] = count;
                count = count + 1;
                row = row - 1;
                col = col - 1;
            }

        }
        answer = new int[max];
        int index = 0;
        for (int[] rows : box) {
            for (int num : rows) {
                if (num == 0) {
                    break;
                }
                answer[index] = num;
                index = index + 1;
            }
        }

        return answer;
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
    public static int solution2(String numbers) {
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
