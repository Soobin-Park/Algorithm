package main.java.com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_웰컴키트_30802 {
    static int n, t, p, orders;
    static int[] tShirts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tShirts = new int[6];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++){
            tShirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        orders = 0;

        for(int i=0;i<6;i++){
            while(tShirts[i]>0){
                tShirts[i] -= t;
                orders ++;
            }
        }

        System.out.println(orders);
        System.out.println(n/p+" "+n%p);

    }
}
