package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_로또_6603_2 {
    static int k;
    static int[] S, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0)
                break;

            S = new int[k];
            selected = new int[6];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            System.out.println();
        }

    }

    static void comb(int cur, int start) {
        if (cur == 6) {
            for (int i = 0; i < 6; i++)
                System.out.print(selected[i] + " ");
            System.out.println();
            return;
        }
        for (int i = start; i < k; i++) {
            selected[cur] = S[i];
            comb(cur + 1, i + 1);

        }


    }
}
