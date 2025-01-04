package main.java.com.algo.baekjoon;

import java.io.*;
import java.util.*;

public class bj_최소스패닝트리_1197 {
    static int v, e, minCost;
    static int[][] graph;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new int[e][3];
        parents = new int[v+1];

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        //모든 간선을 가중치 오름차순으로 정렬
        Arrays.sort(graph,(o1,o2) -> Integer.compare(o1[2], o2[2]));

        minCost = 0;
        //집합 만들기
        for(int i=0;i<v;i++){
            parents[i] = i;
        }
        //가중치 낮은 간선부터 돌면서
        //간선이 추가되면 사이클이 되는지 확인함 -> 유니온파인드
        //사이클되면 넘기고
        //사이클 안되면 추가하기!
        for(int i=0;i<e;i++){
            if(find(graph[i][0]) != find(graph[i][1])){
                union(graph[i][0], graph[i][1]);
                minCost += graph[i][2];
                continue;
            }
        }

        System.out.println(minCost);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b)
            parents[a] = b;
        else
            parents[b] = a;
    }

    static int find(int x){
        if(parents[x] == x)
            return x;
        else
            return find(parents[x]);
    }

}
