package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이로몇번나누어질까1407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(-calSumPowerOfTwo(Long.parseLong(st.nextToken())-1) + calSumPowerOfTwo(Long.parseLong(st.nextToken())));

    }

    private static long calSumPowerOfTwo(long x){
        long result = x;
        for (long l = 2;l <= x; l <<=1){
            result += (x/l) *(l >> 1);
        }
        return result;
    }
}
