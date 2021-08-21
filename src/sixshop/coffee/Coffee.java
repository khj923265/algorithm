package sixshop.coffee;

import java.util.ArrayList;
import java.util.List;

public class Coffee {

    public static void main(String[] args) {
        int[] coffee_times = {4, 2, 2, 5, 3};
        int N = 3;

        Coffee coffee = new Coffee();
        int[] answer = coffee.solution(N, coffee_times);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public int[] solution(int N, int[] coffee_times) {
        List<Integer> answerList = new ArrayList<>();
        int[] answer = new int[coffee_times.length];

        while (answerList.size() < coffee_times.length){
            for (int i = 0; i < N; i++) {
                if (coffee_times[i] != 0){
                    coffee_times[i] -= 1;
                    if (coffee_times[i] == 0 || answerList.size() + 1 == coffee_times.length) {
                        answerList.add(i + 1);
                        if (N < coffee_times.length) {
                            N++;
                        }
                    }
                }
            }
        }



        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
