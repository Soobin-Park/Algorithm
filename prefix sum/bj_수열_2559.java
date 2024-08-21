package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_수열_2559 {
    static int n, k;
    static int[] seq,prefixSum;
    public static void main(String[] args) throws IOException {
        //연속된 k일의 온도의 합이 최대가 되는 값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seq = new int[n];
        prefixSum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
            prefixSum[i+1] = seq[i]+ prefixSum[i];
        }

        //값들에 마이너스 있을 수 있어서 초기화를 0으로 하면 안되는듯
        int maxSum = -100 * k;
        for ( int i=0;i<=n-k;i++){
            int tempSum = prefixSum[k+i]-prefixSum[i];
            maxSum = Math.max(tempSum,maxSum);
        }

        System.out.println(maxSum);

    }
}
