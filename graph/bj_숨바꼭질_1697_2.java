package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_숨바꼭질_1697_2 {
    static int n, k;

    static int[] dx = {-1, 1, 0};
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(visited,-1);

        if(n ==k)
            System.out.println(0);
        else
            bfs(n);
    }

    static void bfs(int start) {
        int res = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;
        int cur;

        while (!q.isEmpty()) {
            cur = q.poll();

            if (cur == k) {
                System.out.println(visited[cur]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = cur + dx[i];
                if (i == 2)
                    next *= 2;

                if (next < 0 || next > 100000)
                    continue;

                if (visited[next] != -1)
                    continue;

                q.add(next);
                visited[next] = visited[cur]+1;
            }
        }
    }
}
