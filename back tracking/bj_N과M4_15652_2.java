package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_N과M4_15652_2 {
    static int n, m;
    static int[] selected;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];
        sb = new StringBuilder();

        recur(0);
        System.out.println(sb);

    }
    static void recur(int cur){
        if( cur == m){
            for(int i=0;i<m;i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            if(cur!=0 && selected[cur-1] > i)
                continue;
            selected[cur] = i;
            recur(cur+1);

        }

    }
}
