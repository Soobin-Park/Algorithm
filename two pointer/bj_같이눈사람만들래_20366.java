package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_같이눈사람만들래_20366 {
    //O(n^3)
    static int n;
    static int[] h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(h);
        int minDiff = Integer.MAX_VALUE;

        //하나는 2중 for문 하나는 투포인터
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int snowMan1 = h[i] + h[j];
                int s = 0, e = n - 1;

                while (s < e) {
                    if (s == i || s == j) {
                        s++;
                        continue;
                    }
                    if (e == i || e == j) {
                        e--;
                        continue;
                    }
                    int snowMan2 = h[s] + h[e];
                    minDiff = Math.min(minDiff,Math.abs(snowMan1-snowMan2));

                    if (snowMan1 > snowMan2)
                        s++;
                    else if (snowMan1 < snowMan2)
                        e--;
                    else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(Math.abs(minDiff));
    }

}

