package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class 퇴사2_15486_topDown {

    static int N, result;
    static int[] dp;
    static int[][] consulting;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        consulting = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N];

        for(int i=0;i<N;i++){
            dp[i] = -1;
        }

        //N일 중 최대한 많이 상담 -> 최대 수익
        result = recur(0);
        System.out.println(result);
    }
    private static int recur(int cur){
        if(cur > N){
            return (int) -1e9;
        }
        if(cur == N){
            return 0;
        }
        if( dp[cur] != -1){
            return dp[cur];
        }
        dp[cur] = max(recur(cur + consulting[cur][0])+consulting[cur][1],recur(cur+1));
        return dp[cur];
    }
}
