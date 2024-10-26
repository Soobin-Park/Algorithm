package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_바이러스_2606 {
    static int n, m,count;
    static int[][] computers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        computers = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u =Integer.parseInt(st.nextToken());
            int v =Integer.parseInt(st.nextToken());
            computers[u][v] = 1;
            computers[v][u] = 1;
        }
        count=0;
        dfs(1);
        System.out.println(count-1);

    }
    static void dfs(int cur){
        count++;
        visited[cur] = true;

        for(int i=1;i<n+1;i++){
            if(computers[cur][i] != 1)
                continue;
            if(visited[i])
                continue;
            dfs(i);
        }

    }
}
