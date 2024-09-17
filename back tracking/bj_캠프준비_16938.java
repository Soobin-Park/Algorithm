package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj_캠프준비_16938 {
    static int n, l, r, x, res;
    static int[] a;
    static List<Integer> selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        a = new int[n];
        selected = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        //두 문제 이상 고르기
        //문제난이도의 합은 l이상, r 이하, 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 x이상.
        //캠프에 사용할 문제를 고르는 방법의 수
        //각 문제 돌면서 조건 맞으면 고르기
        res = 0;
        recur(0,0);
        System.out.println(res);

    }

    //nC2 + ... nCn
    static void recur(int cur,int sum){
        if( cur == n){
            //두 문제 이상 인지
            if(selected.size() < 2)
                return;
            //문제 난이도의 합 조건이 맞는지
            if(sum < l || sum > r)
                return;
            //문제 난이도 차이 조건이 맞는지
            int maxA = Collections.max(selected);
            int minA = Collections.min(selected);
            if(maxA - minA < x)
                return;

            res ++;
            return;
        }
        //안고르거나
        recur(cur+1,sum);
        //고르거나
        selected.add(a[cur]);
        recur(cur+1,sum+a[cur]);
        selected.remove(selected.size()-1);


    }
}
