package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_퇴사2_15486_2 {
    static int n;
    static int[] t, p, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        t = new int[n];
        p = new int[n];
        dp = new int[n+1];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,-1);
        System.out.println(recur(0));

    }

    static int recur(int cur){
        if (cur == n) {
            return 0;
        }
        if( cur > n){
            return Integer.MIN_VALUE;
        }

        if( dp[cur] != -1) {
            return dp[cur];
        }
        return dp[cur]= Integer.max(recur(cur+t[cur])+p[cur],recur(cur+1));

    }
}
