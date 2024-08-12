package com.algo.baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_편의점2_14400 {
    static int n;
    static int[] housesX, housesY;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        housesX = new int[n];
        housesY = new int[n];

        for (int i = 0; i < n; i++) {
            housesX[i] = sc.nextInt();
            housesY[i] = sc.nextInt();
        }
        Arrays.sort(housesX);
        Arrays.sort(housesY);

        int targetX = housesX[n/2];
        int targetY = housesY[n/2];
        long sum = 0;

        for(int i=0;i<n;i++){
            sum += Math.abs(housesX[i] - targetX) + Math.abs(housesY[i] - targetY);
        }

        System.out.println(sum);

    }
}
