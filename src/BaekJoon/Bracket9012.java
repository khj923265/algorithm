package BaekJoon;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bracket9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 처음 입력받는 숫자
        int inputSize = Integer.parseInt(br.readLine());
        // char 문자열 비교를 위해 미리 만들어둠
        char lp = '(';
        char rp = ')';

        // 처음 입력된 숫자만큼 반복문
        for (int i = 0; i < inputSize; i++){
            String ps = br.readLine();
            int count = 1;
            // 입력받은 괄호문자들 첫번째가 ) 인 경우와 마지막이 ( 인 경우 반복문 안돌고 끝내기위해
            // if 문으로 체크
            if (ps.charAt(0) == rp || ps.charAt(ps.length()-1) == lp){
                bw.write("NO" + "\n");
            } else {
                // 처음과 끝이 정상이면 처음은 무조건 ( 으로 시작이라 count는 1로 잡고 반복문도 1부터 시작함
                for (int j = 1; j < ps.length(); j++){
                    if (ps.charAt(j) == lp){
                        count++;
                    } else if (ps.charAt(j) == rp){
                        --count;
                        // count 가 만약 -가 되면 잘못된 괄호이기 때문에 그냥 카운트를 100줘버림...어케해야할지 모르겠음
                        // -가 되면 그냥 바로 반복문 안돌고 여기서 정지시키고 싶음!
                        if (count == -1){
                            count = 100;
                        }
                    }
                }
                if (count == 0){
                    bw.write("YES" + "\n");
                } else {
                    bw.write("NO" + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
