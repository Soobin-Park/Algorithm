package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수들의합42015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long result = 0;
        //누적합
        List<Integer> number = new ArrayList<>();
        //(누적합, 개수)
        Map<Integer, Long> map = new HashMap<>();
        number.add(0);
        for (int i = 1; i <= n; i++) {
            number.add(Integer.parseInt(st.nextToken()) + number.get(i - 1));
            if (number.get(i) == k)
                result++;
            if (map.containsKey(number.get(i) - k))
                result += map.get(number.get(i) - k);
            if (!map.containsKey(number.get(i)))
                map.put(number.get(i), 1L);
            else
                map.put(number.get(i), map.get(number.get(i)) + 1);
        }

        System.out.println(result);
    }
}
