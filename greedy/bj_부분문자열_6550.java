package main.java.com.algo.baekjoon;

import java.io.*;
import java.util.*;

public class bj_부분문자열_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력이 없을 때까지 입력받기
        //앞의 문자열이 뒤의 문자열의 부분 문자열인지 판단
        //(몇 개의 문자를 제거하고 순서를 바꾸지 않고 합쳤을 경우 되는 경우)
        //대소문자도 같아야함
        //쪼개어져 들어가도 판단할 수 있어야 함

        //s의 처음 문자가 t의 문자열에 있는지 판단
        //만약 있다면 다음 문자를 판단
        //없어도 다음 문자가 같은지를 봐야하는데
        //종료 조건은 s의 문자 끝이나 t의 문자 끝을 다 볼 때까지
        String strings;
        while ((strings = br.readLine()) != null) {

            st = new StringTokenizer(strings);
            String s = st.nextToken();
            String t = st.nextToken();
            boolean flag = true;
            int preIndex = -1;

            for (int i = 0; i < s.length(); i++) {
                for (int j = preIndex + 1; j < t.length(); j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        preIndex = j;
                        break;
                    }

                    if (j == t.length() - 1){
                        flag = false;
                        break;
                    }
                }
                if(!flag)
                    break;
            }

            if(flag)
                System.out.println("Yes");
            else
                System.out.println("No");


        }

    }
}
