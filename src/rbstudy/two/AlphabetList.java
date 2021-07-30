package rbstudy.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AlphabetList {

    public static void main(String[] args) {
        // 규칙은 자유 알아서 출력만 맞으면 됨
        // 출력 결과
        // A B C D E
        // P Q R S F
        // O X Y T G
        // N W V U H
        // M L K J I
        // 5 x 5
        // 남은 결과
        // Z

        // 알파벳 리스트크기만큼 반복
        // 오른쪽이 비어있으면 안빌때까지 이동
        // 아래가 비어있으면 안빌때까지 이동
        // 위가 비어있으면 안빌때까지 이동
        // 왼쪽이 비어 있으면 안빌때까지 이동

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String[][] boardList = new String[6][6];
        String[] alphabetSplitList = alphabet.split("");
        List<String> alphabetList = new LinkedList<>(Arrays.asList(alphabetSplitList));

        insertAlphabetOnBoard(alphabetList, boardList);

        System.out.println("= 결과 출력 =");
        printResult(boardList);

        System.out.println("= 남은 결과 =");
        printRemainResult(alphabetList);

    }

    private static void insertAlphabetOnBoard(List<String> alphabetList, String[][] boardList){
        int alphabetListLength = alphabetList.size() - 1;
        int boardListLength = boardList.length - 1;
        final int zero = 0;
        int row = 1;
        int col = 1;
        boardList[row][col] = alphabetList.get(zero);
        alphabetList.remove(zero);

        // null 체크 말고 다른방법을 찾지 못했습니다.
        // 널체크 때문에 Optional 을 사용하는건 안좋은 방법인것 같고 StringUtils는 라이브러리를 받아야해서 사용을 안했습니다.
        for (int i = 1; i < alphabetListLength; i++) {
            for (int j = i; col < boardListLength && boardList[row][col + 1] == null; j++) {
                boardList[row][col + 1] = alphabetList.get(zero);
                alphabetList.remove(zero);
                col++;
                i = j;
            }
            for (int j = i; row < boardListLength && boardList[row + 1][col] == null; j++) {
                boardList[row + 1][col] = alphabetList.get(zero);
                alphabetList.remove(zero);
                row++;
                i = j;
            }
            for (int j = i; col > 1 && boardList[row][col - 1] == null; j++) {
                boardList[row][col - 1] = alphabetList.get(zero);
                alphabetList.remove(zero);
                col--;
                i = j;
            }
            for (int j = i; row > 1 && boardList[row - 1][col] == null; j++) {
                boardList[row - 1][col] = alphabetList.get(zero);
                alphabetList.remove(zero);
                row--;
                i = j;
            }
        }
    }

    private static void printResult(String[][] boardList){
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (j < 5) {
                    System.out.print(boardList[i][j] + " ");
                } else {
                    System.out.print(boardList[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void printRemainResult(List<String> alphabetList){
        for (String alphabet : alphabetList) {
            System.out.print(alphabet);
        }
    }
}
