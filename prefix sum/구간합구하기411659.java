package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 구간합구하기411659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> numbers = new ArrayList<>();
        List<Integer> prefixSum = new ArrayList<>();
        numbers.add(0);
        //인덱스 1 ~ N
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        int tempSum = numbers.get(0);
        prefixSum.add(numbers.get(0));
        //prefixSums[i] = 1~i까지의 누적합

        for (int i = 1; i <= N; i++) {
            tempSum += numbers.get(i);
            prefixSum.add(tempSum);
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(prefixSum.get(j) - prefixSum.get(i-1));
        }

    }

}