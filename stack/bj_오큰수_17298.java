package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_오큰수_17298 {
    static int n;
    static int[] a, returnA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        returnA = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            /*
             * 스택이 비어있지 않으면서
             * 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
             * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
             * 해당 인덱스의 값을 현재 원소로 바꿔준다.
             */

            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                a[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        /*
         * 스택의 모든 원소를 pop하면서 해당 인덱스의 value를
         * -1로 초기화한다.
         */
        while (!stack.isEmpty()) {
            a[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb);

    }
}
