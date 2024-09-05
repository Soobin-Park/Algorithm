package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_K번째수_1300 {
    static int n, k;
    //static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        //nums = new int[n * n];

        //int idx = 0;
        //O(n^2)라 터질 거 같은데..
        //메모리 초과..
        //이분탐색을 하면서 넣어줘야하나 ???
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                nums[idx++] = i * j;
//            }
//        }
        long s = 1, e = k;
        while (s < e) {
            long mid = (s + e) / 2;
            long count = 0;

            //임의의 x에 대해
            //i번째 행을 나눔으로써 x보다 작거나 같은 원소의 개수 -> 누적합
            //n*n행렬에서 mid보다 작거나 같은 원소의 개수를 세는 것.
            //열 원소개수 안넘게 n으로 min
            for (int i = 1; i <= n; i++)
                count += Math.min(mid / i, n);

            if (k <= count)
                e = mid;
            else {
                s = mid + 1;
            }
        }
        System.out.println(s);

        //System.out.println(nums[k]);

    }

}
