package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 보석도둑14232 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long n = Long.parseLong(st.nextToken());

        int c = 2;
        int count = 0;

        List<String> result = new ArrayList<>();
        while (n != 1) {
            //루트n보다 커지는 약수 거르기
            if (c >= 1000000) {
                result.add(n + "");
                count++;
                break;
            }
            if (n % c == 0) {
                n /= c;
                count++;
                result.add(c + "");
            } else {
                c++;
            }
        }
        System.out.println(count);
        System.out.println(String.join(" ", result));

    }
}
