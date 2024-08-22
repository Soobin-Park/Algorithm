package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_나는정말휘파람을못불어_24956 {
    static int n, mod = 1000000007;
    static long res;
    static long[] prefix_sum;
    static String s;
    public static void main(String[] args) throws IOException {
        //WHEE의 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prefix_sum = new long[3];
        res = 0;
        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        for( int i=0;i<n;i++){
            if(s.charAt(i) == 'W'){
                prefix_sum[0]++;
            } else if (s.charAt(i) == 'H') {
                prefix_sum[1] += prefix_sum[0];
            }else if(s.charAt(i) == 'E'){
                res = (2*res+prefix_sum[2])%mod;
                //뒤에 E가 더붙으면 가짓수가 두 배가 되어서 곱해줌
                //그 이전 가짓수 더해주는 것
                prefix_sum[2] += prefix_sum[1];
                //업데이트

            }
        }

        System.out.println(res);

    }
}
