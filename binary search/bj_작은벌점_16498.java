package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_작은벌점_16498 {
    static int na, nb, nc;
    static int[] aCard, bCard, cCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        na = Integer.parseInt(st.nextToken());
        nb = Integer.parseInt(st.nextToken());
        nc = Integer.parseInt(st.nextToken());

        aCard = new int[na];
        bCard = new int[nb];
        cCard = new int[nc];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < na; i++) {
            aCard[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++) {
            bCard[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nc; i++) {
            cCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aCard);
        Arrays.sort(bCard);
        Arrays.sort(cCard);

        //결과 반환용
        int answer = Integer.MAX_VALUE;

        //셋을 거의 비슷한 수를 뽑아야함
        //-> 여기서 이분탐색

        for (int i = 0; i < na; i++) { //O(na*(log(nb)+2*log(nc)))
            int selectA = aCard[i];
            int selectB = nearestNum(selectA, bCard);
            int selectC1 = nearestNum(selectA, cCard);
            int selectC2 = nearestNum(selectB, cCard);
            int max1 = Math.max(Math.max(selectA, selectB), selectC1);
            int min1 = Math.min(Math.min(selectA, selectB), selectC1);
            int score1 = max1 - min1;

            int max2 = Math.max(Math.max(selectA, selectB), selectC2);
            int min2 = Math.min(Math.min(selectA, selectB), selectC2);
            int score2 = max2 - min2;

            answer = Math.min(answer, Math.min(score1, score2));
        }
        System.out.println(answer);

    }

    //가까운 수 이분탐색으로 찾기
    public static int nearestNum(int target, int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        int mid = (s + e) / 2;
        int nearest = arr[mid];

        while (s <= e) {
            mid = (s + e) / 2;
            if (arr[mid] == target) return target;
            if (arr[mid] < target) {
                s = mid + 1;
            } else if (arr[mid] > target) {
                e = mid - 1;
            }
            if (isMoreApproximated(arr[mid], nearest, target)) {
                nearest = arr[mid];
            }
        }
        return nearest;
    }


    public static boolean isMoreApproximated(int selectedNum, int nearest, int target) {
        if (Math.abs(selectedNum - target) < Math.abs(nearest - target)) return true;
        return false;
    }

}
