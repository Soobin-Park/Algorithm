package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정수좌표의개수16970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int x1 = 0; x1 <= N; x1++) {
            for (int y1 = 0; y1 <= M; y1++) {
                for (int x2 = 0; x2 <= N; x2++) {
                    for (int y2 = 0; y2 <= M; y2++) {
                        if(getGCD(Math.abs(x2-x1),Math.abs(y2-y1)) +1 == K)
                            result ++;
                    }
                }
            }
        }
        System.out.println(result/2);
    }
    private static int getGCD(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;}


}
