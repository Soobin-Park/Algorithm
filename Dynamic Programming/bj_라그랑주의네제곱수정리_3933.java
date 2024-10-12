package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_라그랑주의네제곱수정리_3933 {
    static int n;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //사용할 제곱수, 루트(32768), 2^15+1
        dp = new int[5][182][32769];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 182; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        while(true){
            n = Integer.parseInt(br.readLine());

            if( n == 0)
                break;

            sb.append(recur(0,1,n)).append("\n");

        }
        System.out.println(sb);
    }
    static int recur(int index, int before, int value){
        //값이 잘 줄어든 것
        if( value == 0)
            return 1;

        if(index ==4)
            return 0;

        if(dp[index][before][value] != -1)
            return dp[index][before][value];

        int res = 0;
        //최약의 경우..시간복잡도 O(5*182*32769) 다봐야해서 하지만 한 번 본거는 다시 안봄
        //사용된 제곱수의 개수, 선택가능한 최소 제곱수의 후보, 남은값
        for(int i=before;i<= Math.sqrt(value);i++){
            res += recur(index+1,i,value-i*i);

        }

        return dp[index][before][value]= res;

    }
}
