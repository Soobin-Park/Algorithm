package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_보석상자_2792 {

    static int n, m;
    static int[] gems;

    public static void main(String[] args) throws IOException {
        //한 사람이 갖는 보석의 수가 다 비슷하도록
        //단, 색은 같아야 함
        //못주는 학생이 있어도 됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = 1, e = 0, mid, sum, answer = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gems = new int[m];
        for (int i = 0; i < m; i++) {
            gems[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, gems[i]);
        }

        //s, e, mid는 보석수
        //사람수가 이분탐색의 기준
        //O(loge*m)
        while (s <= e) {
            //질투심이 mid가 되도록 나눠주기
            mid = (s + e) / 2;
            sum = 0;
            for (int i = 0; i < m; i++) {
                sum += gems[i] / mid;
                if (gems[i] % mid != 0) {
                    sum++;
                }
            }
            //못나눠주는경우
            if (sum > n)
                s = mid + 1;
            //나눠줄 수 있는 경우
            else {
                e = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);


    }
}
