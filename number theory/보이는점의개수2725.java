package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 보이는점의개수2725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        List<Integer> numberOfVisiblePoint = new ArrayList<>();
        numberOfVisiblePoint.add(0);
        numberOfVisiblePoint.add(3);
        for(int i=2;i<1001;i++){
            int count = 0;
            for (int j=1;j<i+1;j++){
                if (i == j)
                    continue;
                if (getGCD(i, j) == 1){
                    count += 2;
                }
            }
            numberOfVisiblePoint.add(numberOfVisiblePoint.get(i-1) + count);
        }

        for (int i = 0; i < C; i++) {
            int N = Integer.parseInt(br.readLine());

            //f(n) = 최대공약수가 1인 수 * 2 + f(n-1)
            System.out.println(numberOfVisiblePoint.get(N));
        }
    }

    private static int getGCD(int n, int m) {
        if (n % m == 0)
            return m;
        return getGCD(m, n % m);
    }

}
