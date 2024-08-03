package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_Hoof_Paper_Scissors_14453 {

    private static class Point{
        int pCount;
        int hCount;
        int sCount;

        public Point(int pCount, int hCount, int sCount) {
            this.pCount = pCount;
            this.hCount = hCount;
            this.sCount = sCount;
        }
    }

    static int n;
    static Point[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Point[n+1];
        dp[0] = new Point(0,0,0);

        //누적으로 문자의 개수를 쌓기
        for(int i=1;i<=n;i++){
            dp[i] = new Point(0,0,0);
            char FJGesture = br.readLine().charAt(0);

            if ( FJGesture=='P')
                dp[i].pCount++;
            else if (FJGesture=='H') {
                dp[i].hCount++;
            }else
                dp[i].sCount++;
            
            //개수들 누적
            dp[i].pCount += dp[i-1].pCount;
            dp[i].hCount += dp[i-1].hCount;
            dp[i].sCount += dp[i-1].sCount;
            
        }
        game();

    }
    static void game(){
        int res = Math.max(dp[n].pCount,Math.max(dp[n].hCount,dp[n].sCount));
        for(int i=1;i<n;i++){
            //i기준 왼쪽합
            int left = Math.max(dp[i].pCount,Math.max(dp[i].hCount,dp[i].sCount));
            //i기준 오른쪽합
            int right = Math.max(dp[n].pCount-dp[i].pCount,Math.max(dp[n].hCount - dp[i].hCount,dp[n].sCount- dp[i].sCount));

            //지금까지 기록된 것과 i번째 기준으로 따져본 것 중 큰 거
            res = Math.max(res, left + right);
        }

        System.out.println(res);
    }
}
