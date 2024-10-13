package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_파일합치기_11066 {
    static int k;
    static int[] fileSum;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            k = Integer.parseInt(br.readLine());
            fileSum = new int[k+1];
            dp = new int[k+1][k+1];
            st = new StringTokenizer(br.readLine());

            for(int j=1;j<=k;j++){
                fileSum[j] = fileSum[j-1]+Integer.parseInt(st.nextToken());
                Arrays.fill(dp[j],-1);
            }

            sb.append(recur(1,k)).append("\n");
        }
        System.out.println(sb);

    }
    static int recur(int cur, int to){
        if (cur == to) {
            return 0;
        }

        if( dp[cur][to] != -1)
            return dp[cur][to];

        int res = Integer.MAX_VALUE;
        for(int i=cur;i<to;i++){
            //i번째 파일을 안고르고 고르고
            //인접한거끼리 묶어야함....!
            res = Math.min(res,recur(cur,i)+recur(i+1,to));
        }
        res += fileSum[to] - fileSum[cur-1];
        return dp[cur][to] = res;

    }
}
