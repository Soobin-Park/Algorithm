package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_일곱난쟁이_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        Arrays.sort(heights);

        int target = sum - 100;
        int s = 0;
        int e = 8;

        //나머지 두 개로 투포인터
        while (s < e) {
            if (heights[s] + heights[e] == target) {
                break;
            } else if (heights[s] + heights[e] > target) {
                e--;
            } else {
                s++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            if (i != s && i != e) {
                sb.append(heights[i] + "\n");
            }
        }

        System.out.print(sb);
    }
}
