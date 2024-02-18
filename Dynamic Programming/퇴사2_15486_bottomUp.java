package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class 퇴사2_15486_bottomUp {

    static int N, result;
    static int[] dp;
    static int[][] consulting;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        consulting = new int[N+1][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1];

        //N일 중 최대한 많이 상담 -> 최대 수익
        memorization();
        System.out.println(dp[N]);
    }
    private static void memorization(){
        int maxP = 0;
        for(int i=0;i<=N;i++) {
            maxP = max(maxP,dp[i]);
            int next = i + consulting[i][0];
            if(next > N)
                continue;
            dp[next] = max(dp[next],maxP+consulting[i][1]);

        }
    }
}
