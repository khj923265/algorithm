package programers;

public class TargetNumber {

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(targetNumber.solution(numbers,target));

    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = bfs(numbers, target, 0, 0);

        return answer;
    }

    public int bfs(int[] numbers, int target, int sum, int i) {

        if(i == numbers.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;
        result += bfs(numbers, target, sum+numbers[i], i+1);
        result += bfs(numbers, target, sum-numbers[i], i+1);
        return result;
    }

}
