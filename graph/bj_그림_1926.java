package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.max;

public class bj_그림_1926 {

    static int n, m, resS, resCount;
    static int[][] picture;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        //가장 넓은 그림의 넓이
        //가로세로는 이어진 것, 대각선은 떨어진 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        picture = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        resS = 0;
        resCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 1 && !visited[i][j]){
                    resS = max(resS,bfs(i,j));
                }
            }
        }

        System.out.println(resCount);
        System.out.println(resS);


    }
    //모든 정점의 모든 간선을 본다고 생각
    //DFS와 BFS의 시간 복잡도 = O(V + E) (V: vertex 개수, E: edge 개수)
    //① V (vertex 개수): n x m
    //② E (edge 개수): 4V (넉넉하게 한 vertex 에 연결된 vertex 상하좌우 4개로 생각)
    //=> 최대 O(V + E) = O(5V) = O(n x m x n) = O(5 x 500 x 500) = O(1,250,000) << 2억 (2초)
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int temp = 0;

        while (!queue.isEmpty()) {
            int[] curArray = queue.poll();
            temp ++;

            for (int i = 0; i < 4; i++) {
                int nextX = curArray[0] + dx[i];
                int nextY = curArray[1] + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY])
                    continue;

                if (picture[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY});
                    //어라..visited 위에 있을 때는 2배였는데 이제 값이 잡혔네 왜 여기 있어야 하지?
                    //여기 있어야 큐에 넣은 거 다시 안넣음 !!
                    visited[nextX][nextY] = true;
                }
            }
        }
        resCount++;
        return temp;
    }
}


