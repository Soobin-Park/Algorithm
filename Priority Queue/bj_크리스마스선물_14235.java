package main.java.com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_크리스마스선물_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (pq.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(pq.poll());
            }
            else{
                while(a>0){
                    pq.add(Integer.parseInt(st.nextToken()));
                    a--;
                }
            }
        }

    }
}
