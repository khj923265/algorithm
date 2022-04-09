package programers;

import java.util.LinkedList;
import java.util.Queue;

public class TestTwo {

    public static void main(String[] args) {

        // 배열의 인접한 값의 차이가 K 를 넘지않게 위치를 바꿔서 모든 숫자가 K보다 차이가 없게 만들어야 할 때
        // 위치를 바꿀수 있는 최소한의 값을 리턴해라, 불가능시 -1 리턴

//        int[] numbers = {10, 40, 30, 20};
//        int k = 20;
        int result = 0;

        int[] numbers = {3, 7, 2, 8, 6, 4, 5, 1};
        int k = 3;

//        int[] numbers = {50, 10, 80, 5, 60, 70};
//        int k = 30;

        System.out.println(bfs(numbers, k));

    }

    public static int bfs(int[] numbers, int k) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(numbers, 0));

        while (!queue.isEmpty()) {
            Number numberObject = queue.poll();
            boolean check = true;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (k < Math.abs(numberObject.getNumbers()[i] - numberObject.getNumbers()[i + 1])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return numberObject.count;
            }

            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    if (i != j) {
                        Number newNumber = new Number(changeNumbers(numberObject.numbers, i, j), numberObject.count + 1);
                        queue.offer(newNumber);
                    }
                }
            }

        }

        return -1;
    }

    public static int[] changeNumbers(int[] numbers, int i, int j) {
        int[] newNumbers = new int[numbers.length];
        int changeNumber = 0;

        for (int k = 0; k < newNumbers.length; k++) {
            newNumbers[k] = numbers[k];
        }
        changeNumber = newNumbers[i];
        newNumbers[i] = numbers[j];
        newNumbers[j] = changeNumber;

        return newNumbers;
    }
}


class Number {
    int[] numbers;
    int count;

    Number(int[] numbers, int count) {
        this.numbers = numbers;
        this.count = count;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getCount() {
        return count;
    }
}