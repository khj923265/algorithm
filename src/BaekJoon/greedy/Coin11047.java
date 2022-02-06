package BaekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Coin11047 {
    private static int N;
    private static int K;
    private static List<Integer> coinList;
    private static int resultCount;

    public static void main(String[] args) throws IOException {
        /**
         * 동전 0 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coinList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= K) {
                coinList.add(coin);
            }
        }

        while (0 < K) {
            int topIndex = coinList.size() - 1;
            int count = K/coinList.get(topIndex);
            if (0 < count) {
                resultCount += count;
                K %= coinList.get(topIndex);
            }
            coinList.remove(topIndex);
        }
        System.out.println(resultCount);
    }
}
