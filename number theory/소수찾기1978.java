package com.algo.baekjoon;

import java.util.Scanner;

public class 소수찾기1978 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            flag = true;
            int num = scan.nextInt();
            if (num == 1)
                continue;

            for (int j = 2; j <= Math.sqrt(num); j++) {

                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }

        }
        System.out.println(count);

    }
}
