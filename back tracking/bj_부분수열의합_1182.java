package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_부분수열의합_1182 {
    static int n, s, result;
    static int[] seq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        seq = new int[n];
        for(int i=0;i<n;i++)
            seq[i] = Integer.parseInt(st.nextToken());

        result = 0;
        //부분 수열 중 다 더한 값이 S가 되는 경우의 수
        //선택 하고 안하고 합이 s인지 체크
        //크기가 0인 경우 제외
        recur(0,0);
        //recur(0,seq[0]);

        if(s == 0)
            result--;
        System.out.println(result);
    }

    private static void recur(int cur, int sum){
        if(cur == n){
            if(sum == s)
                result++;
            return;
        }

        //나 선택 안하고 다음 거
        recur(cur+1,sum);
        //나 선택하고 다음 거
        recur(cur+1,sum+seq[cur]);

    }
}
