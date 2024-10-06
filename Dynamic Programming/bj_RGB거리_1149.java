package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_RGB거리_1149 {
    static int n;
    static int[][] cost, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //R G B
        cost = new int[n][3];
        //
        dp = new int[n+1][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Integer.min(Integer.min(recur(0, 0),recur(0,1)),recur(0,2)));


    }
    static int recur(int cur,int pre){
        //인접한 집의 색이 같으면 안됨
        if(cur == n){
            return 0;
        }
        if(dp[cur][pre] !=0)
            return dp[cur][pre];

        //나올 수 있는 최대치
        int ret = 1000 * n;
        for(int i=0;i<3;i++){
            if( i == pre)
                continue;
            //모든 경우 다녀오고 최소
            ret = Integer.min(ret,recur(cur+1,i)+cost[cur][i]);
        }

        dp[cur][pre] = ret;
        return dp[cur][pre];


    }
}
