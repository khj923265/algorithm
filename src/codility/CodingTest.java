package codility;

public class CodingTest {

    public static void main(String[] args) {
        int N = 100;
        System.out.println(solution(N));
    }

    public static int solution(int N){
        // if 합계가 1이면 1자릿수만 늘리기 (1이면 10, 10이면 100)
        // if 첫번째 숫자가 0이면 앞자리 숫자를 0으로 만들고 반올림(ex 180 이면 200으로 반올림)
        //    그러고 반올림 한 수의 합계와 N의 합계와 뺸후 한자릿수면 첫번째자리에 삽입
        //    두자릿수면 첫번째 자릿수를 9로 만들고 10의 자리수에 나머지 수 삽입
        //    ex) 1990 = 19자릿수  - > 2000 = 2, 19-2 = 17 2089 = 19
        // else  위에 다 아니면 그냥 첫번째 자리 -1 10의자리 +1 ( ex 164 -> 173 )

        int sum = 0;
        String[] strings = Integer.toString(N).split("");
        int[] ints = new int[strings.length];

        for(int i = 0;i < strings.length; i++){
            sum += N%10;
            ints[i] = N%10;
            N /= 10;
        }
        for (int a : ints){
            System.out.println("a : "+a);
        }
        System.out.println("sum : "+sum);

        if (strings.length == 1){
            strings[0].charAt(0);
        }
        if (sum == 1){

        }else {

        }
        return N;

    }

}
