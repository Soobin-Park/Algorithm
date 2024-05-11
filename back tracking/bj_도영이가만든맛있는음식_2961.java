package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_도영이가만든맛있는음식_2961 {
    static int n, result;
    static int[] sours, bitters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sours = new int[n];
        bitters = new int[n];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            sours[i] = Integer.parseInt(st.nextToken());
            bitters[i] = Integer.parseInt(st.nextToken());
        }

        result = Integer.MAX_VALUE;

        //신맛은 곱
        //쓴맛은 합
        //신맛 쓴맛 차이 가장 작은 값 출력
        recur(0,0,1,0);
        //하나도 안고른 경우 제외.
        System.out.println(result);

    }

    private static void recur(int cur, int count, int sour, int bitter){ //O(2^n)인가
        if(cur == n){

            if(count == 0)
                return;

            int temp = Math.abs(sour - bitter);
            if (result > temp)
                result = temp;
            return;
        }

        recur(cur+1,count,sour,bitter);
        recur(cur+1,count +1,sour*sours[cur],bitter+bitters[cur]);


    }

}
