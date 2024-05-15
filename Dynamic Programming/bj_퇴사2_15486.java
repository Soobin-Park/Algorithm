package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class bj_퇴사2_15486 {

    static int n;
    static int[][] works;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        works = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        //최대 수익
        //상담을 하거나 안하거나
        //n이 크기때문에, 저장하면서 가야함

        //탑다운 시간초과
        //System.out.println(recur(0));

        //바텀업
        memorization();
        System.out.println(dp[n]);

    }

    static int recur(int cur) {
        //절대 답이 될 수 없도록
        if (cur > n)
            return Integer.MIN_VALUE;

        //여기가 문제였군 그냥 리턴했어야했는디
        if (cur == n)
            return 0;

        //다시 온 경우
        if (dp[cur] != -1)
            return dp[cur];

        //처음 온 경우
        dp[cur] = max(recur(cur + 1), recur(cur + works[cur][0]) + works[cur][1]);
        return dp[cur];
    }

    static void memorization() {
        int maxP = 0;
        for (int i = 0; i <= n; i++) {
            maxP = max(maxP, dp[i]);
            int next = i + works[i][0];
            if (next > n)
                continue;
            dp[next] = max(dp[next], maxP + works[i][1]);
        }

    }
}
