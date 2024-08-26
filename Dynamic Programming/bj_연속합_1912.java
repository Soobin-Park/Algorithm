package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_연속합_1912 {
    static int n;
    static int[] nums, prefix_sum,dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        //prefix_sum = new int[n + 1];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            //refix_sum[i + 1] = nums[i] + prefix_sum[i];
        }

        int max = nums[0];

        //연속된 몇 개의 수중 구할 수 있는 합 중 가장 큰 것
        //누적합. 시간초과
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = i + 1; j < n + 1; j++) {
//                temp = prefix_sum[j] - prefix_sum[i]; //i ~ j
//                max = Math.max(temp, max);
//            }
//        }

        dp[0] = nums[0];
        //DP
        for(int i=1;i<n;i++){
            //날 넣거나 안넣거나 중 큰 거
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }
}
