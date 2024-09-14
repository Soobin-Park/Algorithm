package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_로또_6603 {
    static int k;
    static int[] s, selected;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        while(true){
            k = Integer.parseInt(st.nextToken());

            if(k == 0)
                break;

            s = new int[k];
            selected = new int[k];

            for(int i=0;i<k;i++){
                s[i] = Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            sb  = new StringBuilder();
            recur(0,0);
            System.out.println(sb);
        }

    }

    static void recur(int cur, int start){
        if( cur == 6){
            for(int i=0;i<6;i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<k;i++){
            selected[cur] = s[i];
            recur(cur+1,i+1);
        }
    }
}
