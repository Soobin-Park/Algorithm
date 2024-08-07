package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_안테나_18310 {
    static int n;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        houses = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(houses);

        // 배열 요소 중에 하나씩 고름.
        // 거리 합 구함
        // 최소 비교

        // 시간 터질 거 같은데....
        // 중간 주변값에 서 안나오려나 반으로 줄여도 터지네 ㅠ 반복문 하나로 안되나
        // -> 중간값 자체가 베스트라 반복문 돌릴 필요가 x


        if(n % 2 ==0){
            System.out.println(houses[n/2-1]);
        }else{
            System.out.println(houses[n/2]);
        }
    }
}
