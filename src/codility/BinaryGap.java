package codility;

public class BinaryGap {

    public static void main(String[] args) {
        int N = 1376796946;

        System.out.println(BinaryGap.solution(N));

    }

    public static int solution(int N) {
        int max = 0;
        int count = 0;
        int firstCount = 0;
        int binary = 0;

        while(N > 0){
            binary = N % 2;
            if (binary == 1){
                if (firstCount == 0){
                    firstCount = 1;
                }else {
                    if (count > max){
                        max = count;
                    }
                    count = 0;
                }
            }else {
                if (firstCount == 1){
                    count++;
                }
            }
            N /= 2;
        }
        return max;
    }

}
