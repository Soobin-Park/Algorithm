package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_용액_2467 {
    static int n;
    static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int s=0, e=n-1, minS =0, minE =n-1;
        long minSum = Long.MAX_VALUE;

        //두 개 섞어서 절댓값이 가장 작도록
        while(true){
            if( s == e)
                break;

            long tempSum = nums[s] + nums[e];

            if (tempSum == 0){
                minS = s;
                minE = e;
                break;
            }

            if (Math.abs(tempSum) < Math.abs(minSum)){
                minSum = tempSum;
                minS = s;
                minE = e;
            }
            if (tempSum < 0)
                s++;
            else
                e--;

        }

        for (int i = 0; i < n; i++) {
            if (i == minS || i == minE)
                System.out.printf(nums[i] + " ");
        }

    }
}
