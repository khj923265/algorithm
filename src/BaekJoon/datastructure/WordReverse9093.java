package BaekJoon.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WordReverse9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputSize; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int count = st.countTokens();
            for (int j = 0; j < count; j++){
                StringBuilder stringBuilder = new StringBuilder(st.nextToken());
                String str = stringBuilder.reverse().toString();
                bw.write(str + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
