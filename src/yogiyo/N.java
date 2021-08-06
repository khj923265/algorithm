package yogiyo;

import java.util.stream.Stream;

public class N {

    public static void main(String[] args) {
        int N = 44432;

        System.out.println(solution(N));
    }

    public static int solution(int N){
        // 일단 +1 을 함
        // 앞에서 부터 연속 숫자가 있는 지 체크
        // 연속숫자가 없으면 그대로 리턴
        // 있으면 연속숫자가 9인지 확인 후 연속숫자의 뒷자리를 +1 하고 뒷자리를 01로 반복

        ++N;

        int[] intList = Stream.of(String.valueOf(N).split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(intList[0]);

        for (int i = intList.length - 1; i >= 0; i--){
            if (intList[i] == intList[i-1]){ // 연속 숫자가 있는지 확인
                if (intList[i+1] == 9){
                    intList[i-1]++;
                }else {
                    intList[i]++;
                }
            }
        }



        return N;
    }
}
