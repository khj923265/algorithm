package rbstudy.two;

import java.util.Scanner;

/*
    How? > 매트릭스를 공백으로 초기화하고 매트릭스의 끝에 도달하거나 공백이 아닌 값을 만나면 방향을 바꾸는식

    + 예외처리(문자열의 길이보다 매트릭스의 크기가 큰 경우)
    + 매트릭스의 사이즈가 변경되어도 문제 없도록
*/

public class MainRb_js3 {
    private static int SIZE = 5;
    private static int MATRIX_SIZE = SIZE * SIZE;

    // 매트릭스 초기화
    public static void initializeMatrix(char[][] matrix){
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                matrix[i][j] = ' ';
            }
        }
    }

    public static String makeSpiralArray(StringBuilder text, char[][] matrix){

        int i = 0, j = 0;

        String direction = "RIGHT";
        for(int count=0; count<MATRIX_SIZE; count++){
            try{
                // 방향별 index 처리
                switch(direction){
                    // 오른쪽 방향
                    case "RIGHT":
                        matrix[i][j++] = text.charAt(0);
                        if(j == SIZE || matrix[i][j] != ' '){
                            i++;
                            j--;
                            direction = "DOWN";
                        }
                        break;

                    // 아래쪽 방향
                    case "DOWN":
                        matrix[i++][j] = text.charAt(0);
                        if(i == SIZE || matrix[i][j] != ' '){
                            i--;
                            j--;
                            direction = "LEFT";
                        }
                        break;

                    // 왼쪽 방향
                    case "LEFT":
                        matrix[i][j--] = text.charAt(0);

                        if(j == -1 || matrix[i][j] != ' '){
                            i--;
                            j++;
                            direction = "UP";
                        }
                        break;

                    // 위쪽 방향
                    case "UP":
                        matrix[i--][j] = text.charAt(0);

                        if(i == 0 || matrix[i][j] != ' '){
                            i++;
                            j++;
                            direction = "RIGHT";
                        }
                        break;
                }
                text.deleteCharAt(0);
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        if(text != null) {
            return text.toString();
        } else {
            return "No spare text";
        }
    }

    public static void main(String[] args){
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        /*
        //입력받을 경우
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input > ");
        String text = scanner.nextLine();
        */


        StringBuilder tempText = new StringBuilder(text);
        String spareText = new String();

        char[][] matrix = new char[SIZE][SIZE];

        // 공백으로 매트릭스 초기화
        initializeMatrix(matrix);

        // 나선형 매트릭스 생성, 남은 문자열 대입
        spareText = makeSpiralArray(tempText, matrix);

        for(int i=0; i < SIZE; i++){
            for(int j=0; j < SIZE; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Spare text : " + spareText);
    }
}
