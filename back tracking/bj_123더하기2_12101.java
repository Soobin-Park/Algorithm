package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_123더하기2_12101 {
    static int n, k;
    static int[] selected;
    static List<int[]> numList;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        selected = new int[n];
        numList = new ArrayList<>();
        sb = new StringBuilder();

        recur(0, 0);

        if (numList.size()<k) {
            System.out.println(-1);
            return;
        }
        int[] res = numList.get(k-1);
        for (int i = 0; i < n; i++) {
            if (res[i] != 0)
                sb.append(res[i] + "+");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }


    //얼마나 골랐는지, 고른 수들의 합
    static void recur(int cur, int cnt) {
        if (cnt == n) {
            //이거 그냥 selected 넣으면 참조값넣어서 재귀때마다 다른값이 들어가지 x
            numList.add(Arrays.copyOf(selected, n));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (cnt + i <= n) {
                selected[cur] = i;
                recur(cur + 1, cnt + i);

                //초기화 안해주면 다음 재귀에 영향
                selected[cur] = 0;

            }

        }


    }
}
