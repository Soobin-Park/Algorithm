package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_구간합구하기4_11659 {
    static int n, m, i, j;
    static int[] nums, prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        prefixSum = new int[n+1]; //1~n사용 i번째 수 까지의 합
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for(int k=0;k<m;k++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            System.out.println(prefixSum[j] - prefixSum[i-1]);
        }


    }
}
