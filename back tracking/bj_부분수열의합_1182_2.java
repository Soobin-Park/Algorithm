package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_부분수열의합_1182_2 {
    static int n, s,res;
    static int[] nums,selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        selected = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        recur(0,0);

        //아무것도 안고르는 경우 제외
        if(s == 0)
            res--;

        System.out.println(res);

    }
    static void recur(int cur, int sum){
        if( cur == n){
            if (sum == s)
                res++;
            return;
        }

        recur(cur+1,sum);
        recur(cur+1,sum+nums[cur]);



    }
}
