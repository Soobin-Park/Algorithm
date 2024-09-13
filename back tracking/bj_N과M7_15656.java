package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_N과M7_15656 {
    static int n, m;
    static int[] selected,nums;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        selected = new int[m];
        nums = new int[n];

        st= new StringTokenizer(br.readLine());
        for( int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        sb = new StringBuilder();
        recur(0);
        System.out.println(sb);



    }
    static void recur(int cur){
        if(cur == m){
            for(int i=0;i<m;i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++){
            selected[cur] = nums[i];
            recur(cur+1);
        }




    }
}
