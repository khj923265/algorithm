package BaekJoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Editor1406 {

    public static void main(String[] args) throws IOException {
        // 시간초과 에러 뜸 뭔가 잘못 사용한듯
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();
        String str = br.readLine(); // 첫번째 입력 문자 문자열로 변환
        List<Character> list = new LinkedList<Character>(); // 문자열을 LinkedList로 변환
        int value = Integer.parseInt(br.readLine()); // 반복할 숫자 입력

        for(int j = 0; j < str.length(); j++){
            list.add(str.charAt(j));
        }

        int i = list.size(); // 커서의 숫자
        // 첫번째 입력수 만큼 반복
        while (value --> 0){
            // !!!!시간초과!!!!
            String editorInput = br.readLine();
            char editor = editorInput.charAt(0);
            switch (editor){
                case 'L':
                    if (i != 0){
                        i -= 1;
                    }
                    break;
                case 'D':
                    if (i < list.size()){
                        i += 1;
                    }
                    break;
                case 'B':
                    if (i != 0){
                        list.remove(i-1);
                        i -= 1;
                    }
                    break;
                case 'P':
                    char chars = editorInput.charAt(2);
                    list.add(i,chars);
                    i += 1;
                    break;
            }
            // !!!!시간초과!!!!
//            if(editor.contains("L")){
//                if (i != 0){
//                    i -= 1;
//                }
//            }else if (editor.contains("D")){
//                if (i < list.size()){
//                    i += 1;
//                }
//            }else if (editor.contains("B")){
//                if (i != 0){
//                    list.remove(i-1);
//                    i -= 1;
//                }
//            }else if (editor.contains("P")){
//                String[] strings = editor.split(" ");
//                list.add(i,strings[1]);
//                i += 1;
//            }
        }
        for (char a : list){
            bw.append(a);
        }
        System.out.println(bw);
    }

}
