package main.java.com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj_소수의연속합_1644 {

    static int n, count;
    static boolean[] primes;
    static ArrayList<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        //n이하인 소수들 구하기
        primes = new boolean[n+1];
        primes[0] = true;
        primes[1] = true;

        for(int i=2;i*i<=n;i++){ //O(n log log n)
            if(!primes[i]){
                for(int j=i*i; j<=n; j+=i)
                    primes[j] = true;
            }
        }

        for(int i=2;i<=n;i++){ //O(n)
            if(!primes[i])
                primeNumbers.add(i);
        }

        count = 0;

        //연속된 소수로 가능한지 판단, 중복사용 x -> 투포인터
        int start = 0;
        int end = 0;
        int sum = 0;

        while(true){ //O(primeNumbers.size())
            if(sum >= n)
                sum -= primeNumbers.get(start++);
            else if (end == primeNumbers.size())
                break;
            else
                sum += primeNumbers.get(end++);
            if (n == sum)
                count++;
        }

        System.out.println(count);
        }


    }


