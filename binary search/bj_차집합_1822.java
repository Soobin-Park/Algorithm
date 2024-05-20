package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_차집합_1822 {
    static int na, nb,size;
    static int[] a, b;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        na = Integer.parseInt(st.nextToken());
        nb = Integer.parseInt(st.nextToken());
        a = new int[na];
        b = new int[nb];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<na;i++)
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<nb;i++)
            b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        Arrays.sort(b);
        size = 0;

        //이분탐색의 시간복잡도는 얼마지 ->O(logN). 절반씩 봐야할 게 줄어들어서 밑은 2
        //여기서는 O(na * lognb)
        //해시맵쓴경우의 시간복잡도
        //삽입, 조회때 O(1). 해시충돌시.. O(n<<키의 개수임) & 순서유지 x
        //해시 충돌이란 값이 다른데 해시 함수를 통해 나온 결과값이 같은 경우
        //일정 크기 이상이 되면? 공간을 두 배씩 늘린다고 함
        //트리맵 사용시 -> O(logN) & 순서유지
        for(int i=0;i<na;i++){
            boolean check = false;
            int j = 0;
            int k = nb-1;
            
            //=주의
            while(j<=k){
                int mid = (j + k) / 2;

                if(b[mid] == a[i]){
                    check = true;
                    break;
                }

                //여기...  -1 +1 안해서였음
                if(b[mid]> a[i]){
                    k = mid - 1;
                }else{
                    j = mid + 1;
                }

            }

            if(check)
                continue;

            sb.append(a[i]+" ");
            size ++;

        }

        System.out.println(size);
        System.out.println(sb);

    }
}
