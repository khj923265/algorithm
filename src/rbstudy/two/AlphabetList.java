package rbstudy.two;

import java.util.*;

public class AlphabetList {

    public static void main(String[] args) {
        // 규칙은 자유 알아서 출력만 맞으면 됨
        //출력 결과
        //A B  C D E
        //P Q  R S F
        //O X  Y T G
        //N W V U H
        //M L  K J  I
        // 5 x 5
        //남은 결과
        //Z

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String[][] boardList = new String[6][6];
        String[] alphabetSplitList = alphabet.split("");
        List<String> alphabetList = new ArrayList<>(Arrays.asList(alphabetSplitList));

        insertAlphabetOnBoard(alphabetList, boardList);

        System.out.println("= 결과 출력 =");
        printResult(boardList);

        System.out.println("= 남은 결과 =");
        printRemainResult(alphabetList);

    }

    private static void insertAlphabetOnBoard(List<String> alphabetList, String[][] boardList){
        int alphabetListLength = alphabetList.size() - 1;
        final int zero = 0;
        int v = 1;
        int h = 1;
        boardList[v][h] = alphabetList.get(zero);
        alphabetList.remove(zero);

        for (int i = 1; i < alphabetListLength; i++) {
            for (int j = i; h < 5 && boardList[v][h + 1] == null; j++) {
                boardList[v][h + 1] = alphabetList.get(zero);
                alphabetList.remove(zero);
                h++;
                i = j;
            }
            for (int j = i; v < 5 && boardList[v + 1][h] == null; j++) {
                boardList[v + 1][h] = alphabetList.get(zero);
                alphabetList.remove(zero);
                v++;
                i = j;
            }
            for (int j = i; h > 1 && boardList[v][h - 1] == null; j++) {
                boardList[v][h - 1] = alphabetList.get(zero);
                alphabetList.remove(zero);
                h--;
                i = j;
            }
            for (int j = i; v > 1 && boardList[v - 1][h] == null; j++) {
                boardList[v - 1][h] = alphabetList.get(zero);
                alphabetList.remove(zero);
                v--;
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
            System.out.print(alphabet + " ");
        }
    }
}
