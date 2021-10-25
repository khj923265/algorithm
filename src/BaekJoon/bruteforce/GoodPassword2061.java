package BaekJoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class GoodPassword2061 {

    public static void main(String[] args) throws Exception {
        /**
         *  좋은 암호 문제
         *  K, L 이 주어지고 K 인수분해 했을 때 사용하는 값이 모두 L 이상인지 확인하기.
         */

        // ex) K = 143, L = 11;
        // K의 인수분해값은 143, 11 * 13 두가지뿐
        // 143, 11, 13 모두 11이상인 값들이기 때문에 GOOD

        // 에라토스테네스의 체 (소수를 구하는 공식)
        // https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger K = new BigInteger(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[L + 1];
        primes[1] = true;

        // 소수 구하기
        for(int i = 2 ; i < L ; i++){
            // 소수가 아닌(true) 수는 넘어가기
            if(!primes[i]) {
                for(int j = i + i ; j <= L ; j += i){ // i를 제외한 i의 배수 모두 체크하기
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < L; i++) {
            if(primes[i]) continue; // 소수가 아닌(true) 수는 넘어가기
            BigInteger bigI = new BigInteger(Integer.toString(i));
            if (K.mod(bigI).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("BAD " + i);
                return;
            }
        }
        System.out.println("GOOD");
    }
}
