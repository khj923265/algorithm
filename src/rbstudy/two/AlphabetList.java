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

        // 이중배열쓰면 될듯?
        // 남은 결과는 삭제로 하는게 낫겠다

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String[] alphabetList = alphabet.split("");
        int alphabetListLength = alphabetList.length;

        printResult(alphabetList, alphabetListLength);

        printRemainResult(alphabetList, alphabetListLength);

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
