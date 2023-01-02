package rbstudy.algorithm;

import java.util.Scanner;

public class test1 {

    public static void main(String[] args ) {
        // 아래에 1,2,3 입력이 되었을때 Pair 체크를 하시오.
        String test1 = "{[()]}";
        String test2 = "{[(]}";
        String test3 = "{";

        // 임의 입력 부분
        Scanner sc = new Scanner(System.in);
        System.out.print("임의로 입력해주세요 >>> : ");
        String test = sc.next();

// ---------------출력------------------------------------------
        System.out.println(TF(test1));
        System.out.println(TF(test2));
        System.out.println(TF(test3));

        System.out.println("임의로 입력한 값의 Pair는 >>> : "+TF(test));

    }

    // Pair 판별 메소드
    public static boolean TF(String str) {

        // 최종결과 리턴할 불리언 변수
        boolean result = false;

        // [], {}, ()
        boolean big_gwal = false;
        boolean	middle_gwal = false;
        boolean small_gwal = false;

        // 각각 괄호가 짝이 없으면  false
        // 입력 문자열 배열에 담기
        String [] open = str.split("");

        // 입력 문자열 길이만큼 괄호 닫는 부분으로 변경하여 배열에 담기
        String changeStr = str.replace("[","]");
        changeStr = changeStr.replace("{","}");
        changeStr = changeStr.replace("(",")");
        String [] close = changeStr.split("");

        // 입력문자열  str의 길이만큼 반복문
        for(int i=0; i<str.length(); i++) {
            if(str.contains(open[i])) {
                if(str.contains(close[i])){
                    if(open[i].equals("[")) {
                        big_gwal = true;
                    }
                    if(open[i].equals("{")) {
                        middle_gwal = true;
                    }
                    if(open[i].equals("(")) {
                        small_gwal = true;
                    }
                }
            }
        } //for문 닫기

        // 모든 괄호가 참이면 result - true 리턴
        if(big_gwal && middle_gwal && small_gwal) {
            result = true;
        }

        return result;
    }

}
