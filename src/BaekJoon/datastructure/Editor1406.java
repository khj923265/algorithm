package BaekJoon.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Editor1406 {

    public static void main(String[] args) throws IOException {
        //TODO 스택으로 풀어보기

        // 시간초과 에러 뜸 뭔가 잘못 사용한듯
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine(); // 첫번째 입력 문자 문자열로 변환
        List<Character> list = new LinkedList<>(); // 문자열을 LinkedList로 변환
        int testCase = Integer.parseInt(br.readLine()); // 반복할 숫자 입력

        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }

        int i = list.size(); // 커서의 숫자
        // 첫번째 입력수 만큼 반복
        while (testCase --> 0){
            // !!!!시간초과!!!!
            String editorInput = br.readLine();
            char editor = editorInput.charAt(0);
            switch (editor){
                case 'L':
                    if (i != 0){
                        --i;
                    }
                    break;
                case 'D':
                    if (i < list.size()){
                        ++i;
                    }
                    break;
                case 'B':
                    if (i != 0){
                        list.remove(i-1);
                        --i;
                    }
                    break;
                case 'P':
                    char chars = editorInput.charAt(2);
                    list.add(i,chars);
                    ++i;
                    break;
            }
        }
        for (char c : list){
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
}
