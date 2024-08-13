package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_체커_1090 {
    static int n;
    static int[] answer;
    static int[][] checkers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st;
        checkers = new int[n][2];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            checkers[i][0] = Integer.parseInt(st.nextToken());
            checkers[i][1] = Integer.parseInt(st.nextToken());
        }

        //입력값 안에서 모여야 최소가 나온다.

        for(int[] x : checkers){
            for(int[] y : checkers){
                int[] cost = new int[n];
                for(int i=0; i<n;i++){
                    cost[i] = Math.abs(x[0]-checkers[i][0]) + Math.abs(y[1]-checkers[i][1]);
                }
                Arrays.sort(cost);

                int temp = 0;
                for(int i=0;i<n;i++){
                    temp += cost[i];
                    answer[i] = Math.min(temp, answer[i]);
                }

            }
        }

        for(int i=0;i<n;i++){
            sb.append(answer[i]+" ");
        }
        System.out.println(sb);

    }
}
