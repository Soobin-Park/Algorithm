package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_숨바꼭질_1697 {
    static int N, K;

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited, -1);

        if (N == K)
            System.out.println(0);
        else
            bfs(N, K);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 0;

        int now;

        while (!queue.isEmpty()) {
            now = queue.poll();

            if (now == k) {
                System.out.println(visited[now]);
                return;
            }

            //이렇게 나눈거랑 dx로 -1,1 넣어두고 2 따로 처리한 거랑 처리하는 범위가 다른가?

            if (now - 1 >= 0 && visited[now - 1] == -1) {
                queue.offer(now - 1);
                visited[now - 1] = visited[now] + 1;
            }
            if (now + 1 <= 100000 && visited[now + 1] == -1) {
                queue.offer(now + 1);
                visited[now + 1] = visited[now] + 1;
            }
            if (now * 2 <= 100000 && visited[now * 2] == -1) {
                queue.offer(now * 2);
                visited[now * 2] = visited[now] + 1;
            }

        }

    }

}
