package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_출근경로_5569 {
    static int w, h;
    static int[][][][] dp;
    static final int MOD = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        dp = new int[w+1][h+1][2][2];

        for(int i=0;i<w+1;i++){
            for(int j=0;j<h+1;j++) {
                for(int k=0;k<2;k++)
                    Arrays.fill(dp[i][j][k], -1);
            }
        }

        System.out.println((recur(1,1,0,1)+recur(1,1,1,1))%MOD);

    }
    // 상하 0 좌우 1
    static int recur(int curX, int curY, int preDir, int flag){

        if( curX == w && curY == h)
            //여긴 0이 아님. 도착하면 1
            return 1;

        if( curX > w || curY > h)
            return 0;

        if( dp[curX][curY][preDir][flag] != -1)
            return dp[curX][curY][preDir][flag];

        //방향을 바꾼 직후에 바로 바꿀 수 x
        int temp = 0;

        // 좌우 이동이 될 때. 이전이 좌우 || 방향 전환 될 때
        if (preDir == 1 || flag == 0) {
            temp += recur(curX+1, curY, 1, preDir == 0 ? 1 : 0) % MOD;
        }

        // 상하 이동이 될 때. 이전이 상하 || 방향 전환 될 때
        if (preDir == 0 || flag == 0) {
            temp += recur(curX, curY+1, 0, preDir == 1 ?1 : 0) % MOD;
        }

        return dp[curX][curY][preDir][flag] = temp % MOD;

    }
}
