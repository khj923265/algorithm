package programers.skillcheck;

import java.util.ArrayList;
import java.util.List;

public class Level1 {

    public static void main(String[] args) {

    }

    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        return answer;
    }

    // 최소 직사각형
    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxVertical = 0;

        for (int[] length : sizes) {
            int width = length[0]; // 가로
            int vertical = length[1]; // 세로
            if (width < vertical) {
                int empty = width;
                width = vertical;
                vertical = empty;
            }
            if (maxWidth < width) {
                maxWidth = width;
            }
            if (maxVertical < vertical) {
                maxVertical = vertical;
            }
        }
        answer = maxVertical * maxWidth;
        return answer;
    }

    // 나누어 떨어지는 숫자 배열
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        if (list.isEmpty()) {
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];
            list.sort(Integer::compareTo);
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }

    // a 와 b 내적
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer = answer + (a[i] * b[i]);
        }
        return answer;
    }
}
