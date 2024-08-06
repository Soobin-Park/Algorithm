package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj_부등호_2529 {
    static int k;
    //static int[] selected;
    static List<String> res = new ArrayList<>();
    static boolean[] visited = new boolean[10];
    static String[] inEqualitySign;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        inEqualitySign = new String[k];
        //selected = new int[k + 1];
        inEqualitySign = br.readLine().split(" ");


        // 부등호 어떻게 저장하지... 배열?
        // 0 ~ 9 중에 k+1개 뽑아 나열
        // 그중, 주어진 부등호 관계 맞는 수 선택
        // 다 골라보고 맞는지 확인 -> 답 되는 거 이어붙여서 숫자로 리스트에 저장해두기
        // 그중 최대, 최수 찾기
        recur(0,"");
        System.out.println(res.get(res.size()-1));
        System.out.println(res.get(0));

    }

    static boolean checkInEqualitySign(int now, int before,int cur) {
        if (inEqualitySign[cur].equals("<") && before < now)
            return true;
        else if (inEqualitySign[cur].equals(">") && before > now)
            return true;
        return false;
    }

    static void recur(int cur, String nums) {
        if (cur == k +1 ) {
            res.add(nums);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (visited[i])
                continue;

            if(cur == 0 || checkInEqualitySign(i,Character.getNumericValue(nums.charAt(cur-1)),cur-1)){
                //selected[cur] = i;
                visited[i] = true;
                recur(cur + 1,nums + i);
                visited[i] = false;
            }

        }

    }

}
