package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_N과M5_15654 {
    static int n, m;
    static int[] nums, selected;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        selected = new int[m];
        visited = new boolean[n];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        recur(0);
        System.out.println(sb);

    }

    static void recur(int cur){
        if (cur == m){
            for(int i=0;i<m;i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            selected[cur] = nums[i];
            visited[i] = true;
            recur(cur+1);
            visited[i] = false;
        }



    }
}
