package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_친구비_16562 {
    static int n, m, k;
    static int[] weight, parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        weight = new int[n+1];
        parent = new int[n+1];
        //부모 초기화 과정
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v,w);
        }

        //모든 사람을 친구로 만드는 최소비용. 안되면 문자 출력
        //다익스트라가 아니라 유니온파인드였네

        int returnMoney = 0;

        for(int i=1;i<=n;i++){
            int now = find(i);

            if(visited[now]){
                visited[i] = true;
                continue;
            }
            returnMoney += weight[now];
            visited[now] = true;
            visited[i] = true;

        }

        if(returnMoney > k)
            System.out.println("Oh no");
        else
            System.out.println(returnMoney);
    }
    static int find(int i){

        if(parent[i]==i)
            return i;
        else
            return find(parent[i]);
    }

    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(weight[parentA]>=weight[parentB])
            parent[parentA] = parentB;
        else
            parent[parentB] = parentA;

    }
}
