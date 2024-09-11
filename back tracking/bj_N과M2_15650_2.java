package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_N과M2_15650_2 {
    static int n, m;
    static int[] selected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        selected = new int[m];
        visited = new boolean[n+1];

        recur(0);

    }

    static void recur(int cur){
        if (cur == m){
            for(int i=0;i<m;i++){
                System.out.print(selected[i]+" ");

            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            if(cur!=0 && selected[cur-1] >= i)
                continue;
            selected[cur] = i;
            visited[i] = true;
            recur(cur+1);
            visited[i]= false;
        }



    }



}
