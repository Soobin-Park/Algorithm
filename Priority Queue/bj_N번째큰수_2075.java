package main.java.com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_N번째큰수_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] seq = new int[N][N];
        //기본이 최소인가
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        //N번째 큰 수 구하기
        //모든 수는 자신의 윗행보다 크다
        //pq에 넣고 n번빼기?

        for(int i=0;i<N-1;i++){
            pq.poll();
        }
        System.out.println(pq.poll());

    }
}
