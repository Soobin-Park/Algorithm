package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_케빈베이컨의6단계법칙_1389 {
    static int n,KevinBaconNum, minKevinBacon;
    static int[][] friends;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        friends = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        //케빈 베이컨의 수가 가장 작은 사람의 수
        //n으로 초기화하면 안됨
        minKevinBacon = Integer.MAX_VALUE;
        int person = 0;
        for(int i = 1; i <= n; i++){
            KevinBaconNum = bfs(i);
            if(KevinBaconNum < minKevinBacon){
                minKevinBacon = KevinBaconNum;
                person = i;
            }
            else if (KevinBaconNum == minKevinBacon) {
                person = Math.min(person, i);
            }
        }
        System.out.println(person);
    }

    static int bfs(int start){
        visited = new int[n+1];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;
        int sum = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=1;i<=n;i++){
                if(visited[i] != -1)
                    continue;

                if(friends[now][i] == 1) {
                    //그냥 1로만 두면 n만 나옴
                    //무조건 sum보다 앞에 있어야 함
                    visited[i] = visited[now] + 1;
                    sum += visited[i];

                    queue.add(i);

                }}
            }
        return sum;
    }
}
