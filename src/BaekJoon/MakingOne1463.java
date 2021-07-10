package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MakingOne1463 {

    public static void main(String[] args) throws IOException {
        solution2();
    }

    public static void firstSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        System.out.println(recur(X, 0));
        br.close();
    }

    public static void secondSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] d = new int[X+1];
        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i <= X; i++){
            if (i%3 == 0 && i%2 == 0){

            }
        }
        br.close();
    }

    public static void solution2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int two = 0;
        int three = 0;

        int temp = n;

        while (temp > 1) {
            if (temp % 2 == 0) {
                temp /= 2;
                two++;
            } else {
                temp -= 1;
                two++;
            }
        }
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
                three++;
            } else {
                n -= 1;
                three++;
            }
        }
        System.out.println(two);
        System.out.println(three);
        System.out.println(Math.min(two, three));
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[0]=0; dp[1]=0; //초기화

        //만약 N=2,3일때 1로 만드는 경우의 수는 1이다.
		/*
		 N을 1로 만드는 경우의 최소 횟수는 =
		1) 'N-1을 1로 만드는 최소 횟수 +1'
		2) 'N/2를 1로 만드는 최소 횟수 +1번'
		3) 'N/3을 1로 만드는 최소 횟수 + 1번'
        */

        /*Bottom-up*/
        for(int i=2;i<=N;i++) {
            if(i%3==0 && i%2==0) {
                dp[i] = Math.min(dp[i/3], Math.min(dp[i-1], dp[i-2])) + 1;
            }
            else if(i%3==0) {
                dp[i] = Math.min(dp[i/3],dp[i-1]) + 1;
            }else if(i%2==0) {
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            }else {
                dp[i] = dp[i-1] + 1;
            }
        }

        System.out.println(dp[N]);
    }

    public static int recur(int X, int count) {
        if (X < 2) {
            return count;
        }
        return Math.min(recur(X / 2, count + 1 + (X % 2)),recur(X / 3, count + 1 + (X % 3)));
    }
}
