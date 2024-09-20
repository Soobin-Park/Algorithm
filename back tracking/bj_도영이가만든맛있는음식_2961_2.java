package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_도영이가만든맛있는음식_2961_2 {
    static int n;
    static long res;
    static long[] sour, bitter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sour = new long[n];
        bitter = new long[n];

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            sour[i] = Long.parseLong(st.nextToken());
            bitter[i] = Long.parseLong(st.nextToken());
        }

        res = Long.MAX_VALUE;
        recur(0,0,1,0);
        System.out.println(res);

    }
    static void recur(int cur, int count, long s, long b){
        if(cur == n){
            if(count == 0)
                return;

            res = Math.min(res,Math.abs(s-b));
            return;
        }

        recur(cur+1,count,s,b);
        recur(cur+1,count+1,s*sour[cur],b+bitter[cur]);

    }

}
