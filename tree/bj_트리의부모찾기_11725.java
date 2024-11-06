package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_트리의부모찾기_11725 {
    static int n;
    static ArrayList<Integer>[] graph;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        parents = new int[n+1];

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1,0);

        //루트는 1
        for(int i=2;i<n+1;i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }


    static void dfs(int cur, int prev) {
        parents[cur] = prev;
        for (int next : graph[cur]) {
            if (next != prev) { // 부모 노드로 돌아가지 않음
                dfs(next, cur);
            }
        }
    }
}
