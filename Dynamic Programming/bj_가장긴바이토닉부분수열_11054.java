package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_가장긴바이토닉부분수열_11054 {
    static int n;
    static int[] a, upDp, downDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        upDp = new int[n];
        downDP = new int[n];
        Arrays.fill(upDp, 1);
        Arrays.fill(downDP, 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        //증가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    upDp[i] = Math.max(upDp[i], upDp[j] + 1);
                }
            }
        }
        //감소
        for (int i =n-1; i >=0; i--) {
            for (int j = n-1; j > i; j--) {
                if (a[i] > a[j]) {
                    downDP[i] = Math.max(downDP[i], downDP[j] + 1);
                }
            }
        }

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, upDp[i]+downDP[i]-1);
        }

        System.out.println(maxLength);

    }

}
