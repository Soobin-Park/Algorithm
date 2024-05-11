package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_암호만들기_1759 {
    static int l, c;
    static char[] chars, selected;
    static List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //안골라도 빈칸넣어서 c칸이어야함
        selected = new char[c];
        chars = new char[c];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++)
            chars[i] = st.nextToken().charAt(0);

        Arrays.sort(chars); //사전순
        recur(0, 0);
        //최소 한 개의 모음, 두 개의 자음, 정렬
        System.out.println(sb.toString());
    }

    static void recur(int cur, int cnt) { //O(2^n). 한 번에 두 개씩 부르니까
        if (cur == c) {
            if (cnt != l)
                return;

            int vowel = 0;
            for (int i = 0; i < l; i++) {
                if (vowels.contains(selected[i]))
                    vowel++;
            }
            if (vowel < 1 || (l - vowel) < 2)
                return;

            for (int i = 0; i < l; i++) {
                sb.append(selected[i]);
            }
            sb.append("\n");

            return;
        }

        selected[cnt] = chars[cur];
        recur(cur + 1, cnt + 1);
        selected[cnt] = ' ';
        recur(cur + 1, cnt);

    }

}
