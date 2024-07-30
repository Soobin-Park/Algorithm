package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_개똥벌레_3020 {
    static int n, h, minCount, minSectionCount;
    static int[] down, up;

    public static void main(String[] args) throws IOException {
        //파괴해야하는 최소 장애물 개수 & 최소 구간 개수
        //처음은 무조건 석순 다음은 석순 종유석 번갈아서
        //n*h
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        down = new int[h+2];
        up = new int[h+2];
        for (int i = 1; i <= n/2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = h - Integer.parseInt(br.readLine()) +1;
            down[a] ++;
            up[b] ++;
        }
        for(int i=1;i<=h;i++){
            down[i] += down[i-1];
        }

        for(int i=h;i>=1;i--){
            up[i] += up[i+1];
        }

        minCount = n;
        minSectionCount = 0;
        for(int i=1; i<h+1; i++	) {
            //O(h)
            int dif = (down[h]-down[i-1]) + (up[1]-up[i+1]);

            if(dif<minCount) {
                minCount = dif;
                minSectionCount=1;
            }else if(dif == minCount) minSectionCount++;
        }
        System.out.println(minCount +" " + minSectionCount);

    }
}

