package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수열2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
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
        int maxSum = -100 * K;
        //N = K 인 경우, 돌아가지 x
        for (int i = K; i <= N; i++) {
            tempSum = prefixSum.get(i) - prefixSum.get(i-K);
            if (tempSum > maxSum)
                maxSum = tempSum;
        }
        if ( N == K)
            maxSum = prefixSum.get(N);

        System.out.println(maxSum);
    }

}