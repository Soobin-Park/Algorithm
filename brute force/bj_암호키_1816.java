package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_암호키_1816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];

        for(int i=0;i<n;i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        boolean result = true;
        //모든 소인수가 백만보다 크다면 ok
        for(int i=0;i<n;i++){
            result = true;
            for (int j=2;j<=1000000;j++){
                if( nums[i] % j == 0){
                    result = false;
                    break;
                }
            }
            if(result)
                System.out.println("YES");
            else
                System.out.println("NO");

        }

    }
}
