package BaekJoon.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CityOfDistance18352 {
    private static int N;
    private static int M;
    private static int shortestDistance;
    private static int startCity;
    private static int firstNode;
    private static int secondNode;
    private static List<List<Integer>> cityNodeList;
    private static boolean[] visitCheck;

    public static void main(String[] args) throws Exception {
        /**
         * 특정 거리의 도시 찾기 문제
         */

        // 출발도시(startCity) 부터 최단거리(shortestDistance) 의 노드번호를 오름차순으로 출력하기

        N = read();
        M = read();
        shortestDistance = read();
        startCity = read();
        cityNodeList = new ArrayList<>();
        visitCheck = new boolean[N];

        for (int i = 0; i < N; i++) {
            cityNodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            firstNode = read() - 1;
            secondNode = read() - 1;
            cityNodeList.get(firstNode).add(secondNode);
        }

        List<City> cityList = bfs();
        if (cityList.isEmpty()) {
            System.out.println(-1);
        } else {
            cityList.stream()
                    .sorted(Comparator.comparingInt(City::getNode))
                    .forEach(City::printNode);
        }
    }

    private static List<City> bfs() {
        Queue<City> queue = new LinkedList<>();
        List<City> cityList = new ArrayList<>();
        queue.offer(new City(startCity - 1, 0));
        visitCheck[startCity - 1] = true;

        while (!queue.isEmpty()) {
            City city = queue.poll();
            if (city.dist == shortestDistance) {
                cityList.add(city);
                continue;
            }

            for (int cityNumber : cityNodeList.get(city.node)) {
                if (!visitCheck[cityNumber]) {
                    visitCheck[cityNumber] = true;
                    queue.offer(new City(cityNumber, city.dist + 1));
                }
            }
        }
        return cityList;
    }

    private static class City {
        int node;
        int dist;

        public City(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        public int getNode() {
            return node;
        }

        public void printNode() {
            System.out.println(node + 1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
}
