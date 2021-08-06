package programers;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;

public class KNumber {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(KNumber.solution(array, commands)));

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++){
            int[] arrays = Arrays.copyOfRange(array,(commands[i][0])-1,commands[i][1]);
            Arrays.sort(arrays);
            answer[i] = arrays[(commands[i][2])-1];
        }

        return answer;
    }

}
