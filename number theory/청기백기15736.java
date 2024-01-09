package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 청기백기15736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 1;

        for(int i = 2; i <= N; i++){

            if(i * i > N){
                break;
            }
            count++;
        }

        System.out.println(count);
    }

}
