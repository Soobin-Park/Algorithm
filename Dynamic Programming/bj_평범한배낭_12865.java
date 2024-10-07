package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_평범한배낭_12865 {
    static int n, k;
    static int[][] items,dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        items = new int[n][2];
        //무게 정보도 있어야 함
        dp = new int[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<k+1;j++){
                dp[i][j] = -1;
            }
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recur(0,0));

    }
    static int recur(int cur, int w){

        if( w > k)
            return Integer.MIN_VALUE;

        if(cur ==n)
            return 0;

        if(dp[cur][w] != -1)
            return dp[cur][w];

        return dp[cur][w] = Math.max(recur(cur+1,w + items[cur][0])+items[cur][1],recur(cur+1,w));

    }
}
