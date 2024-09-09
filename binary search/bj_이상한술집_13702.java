package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalLong;
import java.util.StringTokenizer;

public class bj_이상한술집_13702 {
    static int n, k;
    static long[] pots;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pots = new long[n];
        for (int i = 0; i < n; i++) {
            pots[i] = Long.parseLong(br.readLine());
        }

        long maxPot = Arrays.stream(pots).max().getAsLong();

        //n개 주전자의 술을 k명에게 최대한 나눠주고 남은 것은 버림
        //무엇을 이분탐색하지?
        //나눈 몫들의 합이 k보다 작으면 최대용량 줄이기 / 크면 최대용량 늘리기

        long s = 1, e = maxPot;
        long mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;

            int tempSum = 0;
            for (int i = 0; i < n; i++) {
                tempSum += pots[i] / mid;
            }

            if (tempSum < k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }


        }

        System.out.println(e);

    }
}
