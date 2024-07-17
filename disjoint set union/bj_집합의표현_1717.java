package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_집합의표현_1717 {
    static int n, m, cal, a, b;
    static int[] parent;
    static boolean isSame;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++){
            parent[i] = i;
        }

        //0이 합집합
        //1이 같은 집합인지 확인 ( 맞으면 YES 아니면 NO )
        //유니온파인드

        //집합 연결을 어떻게 하더라...
        //부모 배열을 하나 만들기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cal = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (cal == 0) {
                union(a, b);
            } else {
                isSame = isSameParent(a, b);
                if (isSame)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }

        }

    }
    static int find(int x){
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b){
            if (a<b)
                parent[b] = a;
            else
                parent[a] = b;
        }

    }

    static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        }
        return false;

    }


}
