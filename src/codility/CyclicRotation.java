package codility;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        System.out.println(Arrays.toString(CyclicRotation.solution(A, K)));

    }

    public static int[] solution(int[] A, int K) {
        if (A.length == 0 || A.length == K){
            return A;
        } else {
            for (int j = 0; j < K; j++) {
                int temp = A[A.length - 1];
                System.arraycopy(A, 0, A, 1, A.length - 1);
                A[0] = temp;
            }
            return A;
        }
    }

}
