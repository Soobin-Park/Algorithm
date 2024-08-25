package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class bj_창고다각형_2304 {

        static int[] heights, leftMax, rightMax;
        static int n, ans;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            heights = new int[1002];
            leftMax = new int[1002];
            rightMax = new int[1002];

            StringTokenizer st;
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                heights[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            for (int i=1; i<=1000; i++) {
                leftMax[i] = Math.max(leftMax[i-1], heights[i]);
            }

            for (int i=1000; i>=1; i--) {
                rightMax[i] = Math.max(rightMax[i+1], heights[i]);
            }

            ans = 0;
            for (int i=1; i<=1000; i++) {
                ans += Math.min(leftMax[i], rightMax[i]);
            }

            System.out.print(ans);

        }

    };