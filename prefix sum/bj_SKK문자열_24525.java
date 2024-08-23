package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj_SKK문자열_24525 {
    public static void main(String[] args) throws IOException {
        //K의 수가 정확이 S의 두배 가장 긴 문자열의 길이
        //없으면 -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //S, K
        int[] prefixSum = new int[s.length()+1];
        int[] countSK = new int[s.length()+1];
        int res = -1;
        Map<Integer,Integer> minIdx = new HashMap<>();

        for(int i=0;i<s.length();i++){
            int temp = 0;
            if(s.charAt(i) == 'S'){
                temp = 2;
            } else if (s.charAt(i) == 'K') {
                temp = -1;
            }
            prefixSum[i+1] = prefixSum[i] + temp;
            countSK[i+1] = countSK[i] + (temp == 0? 0: 1);
        }

        for(int i=0;i<s.length()+1;i++) {
            //문자열 끝이랑 누적합이 같은 곳. 최소 인덱스 갱신
            if (!minIdx.containsKey(prefixSum[i]))
                minIdx.put(prefixSum[i], i);
            else {
                //다르다면, 지금 이랑 누적합이 같은 최소 인덱스 꺼냄
                int midX = minIdx.get(prefixSum[i]);
                //그 인덱스에서, S나 K의 개수가 지금과 같다면 -> 업데이트할 필요 x
                if (countSK[midX] == countSK[i]) continue;
                res = Math.max(res, i - midX);
            }
        }

        System.out.println(res);

    }
}
