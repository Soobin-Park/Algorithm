package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_두수의합_3273 {
    static int n, x, res;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        //완탐은 for 두번 해야해서 시간이 x -> 투포인터
        Arrays.sort(nums);

        res = 0;
        int s =0, e= n-1;
        while(s < e){
            int temp = nums[s] + nums[e];
            if(temp == x) {
                res++;
                //이거 없으면 안끝남
                s++;
                e--;
            }
            if( temp < x){
                s ++;
            }if(temp >x){
                e --;
            }

        }


        System.out.println(res);
    }
}
