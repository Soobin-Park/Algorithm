package main.java.com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_가장긴증가하는부분수열2_12015 {
    static int n;
    static int[] seq;
    static List<Integer> subseq = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n =  Integer.parseInt(br.readLine());
        seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        subseq.add(seq[0]);
        for(int i=1;i<n;i++){ //O(nlogn)

            //현재 부분수열의 마지막값보다 크면 추가
            if(subseq.get(subseq.size()-1)<seq[i]){
                subseq.add(seq[i]);
            }
            //아니라면, 이분탐색으로 다음에 추가할 값 찾기
            else {
                int s = 0;
                int e = subseq.size();
                while(s<e){
                    int mid = (s+e)/2;

                    if(subseq.get(mid) < seq[i])
                        s = mid+1;
                    else
                        e = mid;

                }
                subseq.set(s,seq[i]);

            }

        }

        System.out.println(subseq.size());
    }

}
