package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_제곱수의합_1699 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        //i까지 써봤을 때 최소 수
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(recur(0));

    }

    static int recur(int cur) {
        if (cur == n)
            return 0;
        if (cur > n)
            //이거 Max_value로 하면 recur +1 연산때문에 가장 작은 값으로 되어서 안됨
            return (int) 1e9;

        if (dp[cur] != -1)
            return dp[cur];

        dp[cur] = (int) 1e9;

        for (int i = 1; i <= n; i++) {
            if (i * i > n)
                break;
            dp[cur] = Math.min(dp[cur], recur(cur + i * i) + 1);
        }
        return dp[cur];
    }
}
