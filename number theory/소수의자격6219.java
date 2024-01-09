package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 소수의자격6219 {
    static int D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = A; i <= B; i++) {
            if(isPrime(i) && hasD(i))
                result++;

        }
        System.out.println(result);
    }

    private static boolean hasD(int i) {
        while (i > 0){
            int n = i % 10;
            if(n == D){
                return true;
            }
            i /= 10;
        }
        return false;
    }

    private static boolean isPrime(int n) {
        if(n == 1) return false;
        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}
