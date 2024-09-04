package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class bj_숫자카드2_10816 {
    static int n, m;
    static int[] isInCards, cards;
    static Map<Integer,Integer> countOfCards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        countOfCards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());

            if(countOfCards.containsKey(cards[i]))
                countOfCards.put(cards[i], countOfCards.get(cards[i])+1);
            else
                countOfCards.put(cards[i], 1);
        }
        Arrays.sort(cards);

        m = Integer.parseInt(br.readLine());
        isInCards = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            isInCards[i] = Integer.parseInt(st.nextToken());
        }

        //가지고 있으면 개수 아니면 0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int s = 0, e = n-1;
            boolean flag = false;
            while (s <= e){
                int mid = (s + e) / 2;

                if(isInCards[i] == cards[mid]){
                    //O(n)
                    //int count = Collections.frequency(cards,cards[mid]);
                    int count = countOfCards.get(cards[mid]);
                    sb.append(count+" ");
                    flag = true;
                    break;
                }

                if (isInCards[i] > cards[mid]){
                    s = mid +1;
                }else{
                    e = mid -1 ;
                }

            }
            if (!flag)
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}
