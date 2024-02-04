package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M115649 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        visited = new boolean[N];

        //1~N 자연수 중 중복없이 M개 고른 수열
        permutation(0);
        System.out.println(sb);
    }

    private static void permutation(int cur){
        //만약 고른 개수가 m개면 출력
        if (cur == M){
            for(int num : selected)
                sb.append(num).append(" ");
            sb.append("\n");
            return;
        }
        //아니면 visited, 방문안했으면선택 + 방문 + 다음 재귀 + 방문체크해제
        for(int i=0;i<N;i++){
            if(visited[i])
                continue;
            selected[cur] = i+1;
            visited[i] = true;
            permutation(cur + 1);
            visited[i] = false;
        }

    }
}
