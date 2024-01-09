package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최대GCD9417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            List<Integer> numbers = new ArrayList<>();
            int result = 1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int number = Integer.parseInt(st.nextToken());
                numbers.add(number);
            }

            for(int j=0;j<numbers.size();j++){
                for (int k = j+1;k<numbers.size();k++){
                    int gcd = getGCD(numbers.get(j),numbers.get(k));

                    if( result < gcd )
                        result = gcd;
                }
            }
            System.out.println(result);
        }

    }
    private static int getGCD(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;}


}
