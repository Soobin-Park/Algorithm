package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj_아이폰9S_5883 {
    static int n;
    static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        Set<Integer> peopleSet = new HashSet<>();
        people = new int[n];

        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(br.readLine());
            peopleSet.add(people[i]);
        }

        //어떤 숫자를 빼야 같은 용량을 원하는 사람이 가장 길어질지
        // n은 1000까지 용량은 1000000까지

        int beforePeople, peopleSum, maxSum;
        maxSum = 1;

        for (int i : peopleSet) {
            peopleSum = 1;
            beforePeople = people[0];
            for (int j = 1; j < n; j++) {
                //제외
                if (people[j] == i)
                    continue;
                if (beforePeople == people[j]){
                    peopleSum += 1;
                    maxSum = Math.max(maxSum, peopleSum);}
                else //이전과 다를 경우 초기화
                    peopleSum = 1;
                beforePeople = people[j];
            }
        }
        System.out.println(maxSum);
    }
}
