package com.algo.baekjoon;

import java.io.*;
import java.util.*;

public class bj_구슬게임_2600 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static int b1, b2, b3, k1, k2, winner;
    static int[] marbles = new int[3];
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        b1 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        b3 = Integer.parseInt(st.nextToken());
        marbles = new int[3];
        marbles[0] = b1;
        marbles[1] = b2;
        marbles[2] = b3;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            k1 = Integer.parseInt(st.nextToken());
            k2 = Integer.parseInt(st.nextToken());
            dp = new int[k1 + 1][k2 + 1];
            for (int j = 0; j <= k1; j++) {
                Arrays.fill(dp[j], -1);
            }

            winner = recur(k1, k2);
            if (winner == 1)
                sb.append("A\n");
            else
                sb.append("B\n");

        }
        System.out.print(sb);

    }

    //dp 크기만큼 걸림 O(k1 *k2)
    private static int recur(int curA, int curB) {
        //두 통중에 하나 골라서 b1 b2 b3 만큼만 뺌

        if (curA < 0 || curB < 0)
            return 1;

        if (curA == 0 && curB == 0)
            return 0;

        if (dp[curA][curB] != -1)
            return dp[curA][curB];

        //a가 이길 가능성 찾기 (재귀로)
        int count = 0;
        for (int marble : marbles) {
            //뺄 수 있는 구슬만큼 뺐을 때, a가 지는 경우 -> 한 번만 더하면 a가 이기니까 이김
            if (recur(curA - marble, curB) == 0 || recur(curA, curB - marble) == 0)
                count++;
        }
        if (count > 0)
            return dp[curA][curB] = 1;
        //조건안되면
        return dp[curA][curB] = 0;

    }
}
