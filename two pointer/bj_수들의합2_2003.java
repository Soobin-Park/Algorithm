package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_수들의합2_2003 {
    static int n, m;
    static long res;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        int temp = 0;
        int s = 0, e = 0;
        while (true) {
            if (temp >= m) {
                temp -= nums[s++];
            } else if (e == n) {
                break;
            } else {
                temp += nums[e++];
            }
            if (temp == m) {
                res++;
            }

        }
        System.out.println(res);
    }
}

