package rbstudy.two;

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
        String[][] board = new String[6][6];

        String[] alphabetList = alphabet.split("");
        int alphabetListLength = alphabetList.length;
        int v = 1;
        int h = 1;
        board[v][h] = alphabetList[0];

        for (int i = 1; i < alphabetListLength; i++) {
            if (h < 5 && board[v][h + 1] == null) {
                for (int j = i; h < 5 && board[v][h + 1] == null; j++) {
                    board[v][h + 1] = alphabetList[j];
                    h++;
                    i = j;
                }
            } else if (v < 5 && board[v + 1][h] == null) {
                for (int j = i; v < 5 && board[v + 1][h] == null; j++) {
                    board[v + 1][h] = alphabetList[j];
                    v++;
                    i = j;
                }
            } else if (h > 1 && board[v][h - 1] == null) {
                for (int j = i; h > 1 && board[v][h - 1] == null; j++) {
                    board[v][h - 1] = alphabetList[j];
                    h--;
                    i = j;
                }
            } else if (v > 1 && board[v - 1][h] == null) {
                for (int j = i; v > 1 && board[v - 1][h] == null; j++) {
                    board[v - 1][h] = alphabetList[j];
                    v--;
                    i = j;
                }
            }
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }

    }

    private static void printResult(String[] alphabetList, int alphabetListLength){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < alphabetListLength; i++) {
            if ((i + 1)%5 == 0) {
                for (int j = i - 4; j < i + 1;j++) {
                    if ((j + 1)%5 != 0) {
                        stringBuilder.append(alphabetList[j]).append(" ");
                    } else {
                        stringBuilder.append(alphabetList[j]).append("\n");
                    }
                }
            }
        }
        System.out.println("출력 결과");
        System.out.println(stringBuilder);
    }

    private static  void printRemainResult(String[] alphabetList, int alphabetListLength){
        StringBuilder stringBuilderRemain = new StringBuilder();

        if (alphabetListLength%5 != 0) {
            int remainderLength = alphabetListLength % 5;
            int remainderIndex = alphabetListLength - remainderLength;
            for (int i = 0; i < remainderLength; i++) {
                stringBuilderRemain.append(alphabetList[remainderIndex + i]).append("\n");
            }
        }
        System.out.println("남은 결과");
        System.out.println(stringBuilderRemain);
    }
}
