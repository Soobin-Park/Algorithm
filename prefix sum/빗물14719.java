package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 빗물14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> blocks = new ArrayList<>();

        for (int i = 0; i < w; i++) {
            blocks.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        //나보다 높은 게 왼쪽, 오른쪽에 있어야 함
        //처음, 마지막 블록에는 고일 수 x
        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(blocks.get(j), left);
            }
            for (int j = i + 1; j < w; j++) {
                right = Math.max(blocks.get(j), right);
            }
            if (blocks.get(i) < left && blocks.get(i) < right)
                result += Math.min(left, right) - blocks.get(i);
        }
        System.out.println(result);
    }
}
