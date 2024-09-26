package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_시험감독_13458 {
    static int n, b, c;
    static long res;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        res = 0;

        for(int i=0;i<n;i++){
            //b가 a[i]보다 클 수도 있다 !! 이 경우 a[i]가 음수가 됨
            a[i]-= b;
            res++;

            if(a[i]<=0)
                continue;
            res+=(a[i])/c;
            if(a[i] % c != 0)
                res++;
        }

        System.out.println(res);
    }
}
