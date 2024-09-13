package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_차이를최대로_10819 {
    static int n,res;
    static int[] a,selected;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        visited = new boolean[n];
        selected = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        recur(0);
        System.out.println(res);

    }
    //n개 나열 -> 인덱스로 값 뽑아와서 계산 시키면 될 듯

    static void recur(int cur){ //n! * n-1
        if(cur == n){
            int temp =0;
            for(int i=0;i<n-1;i++){
                temp += Math.abs(a[selected[i]]- a[selected[i+1]]);
            }
            res = Math.max(temp,res);
            return;
        }

        for(int i=0;i<n;i++){
            if(visited[i])
                continue;

            selected[cur] = i;
            visited[i] = true;
            recur(cur+1);
            visited[i] = false;
        }



    }
}
