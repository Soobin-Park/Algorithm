package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] dp;
    static int[][] expense;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        //비용의 최솟값
        dp = new int[N+1][3];
        //1은 2와 달라야함
        //N은 N-1와 달라야함
        //사이값은 양옆과 달라야함
        expense = new int[N][3];

        //빨초파 012
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            expense[i][0] = Integer.parseInt(st.nextToken());
            expense[i][1] = Integer.parseInt(st.nextToken());
            expense[i][2] = Integer.parseInt(st.nextToken());
        }

        int res = Math.min(painting(0,2),Math.min(painting(0,0), painting(0,1)));

        System.out.println(res);
    }

    private static int painting(int cur,int prev){
        if(cur == N){
            return 0;
        }
        if(dp[cur][prev] != 0){
            return dp[cur][prev];
        }
        int ret = 1000* N;
        for(int i=0;i<3;i++){
            if (i == prev)
                continue;
            ret = Math.min(ret,painting(cur+1,i)+expense[cur][i]);
        }
        dp[cur][prev] = ret;
        return dp[cur][prev];
    }

}
