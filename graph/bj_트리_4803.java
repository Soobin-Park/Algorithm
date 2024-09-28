package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_트리_4803 {
    static int n, m, countOfTree;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int tc = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if( n == 0 && m == 0)
                break;

            graph = new ArrayList<>();
            for(int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                //방향x
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
            visited = new boolean[n+1];

            //트리 개수 세기
            //Case 1: A forest of 3 trees.
            //Case 2: There is one tree.
            //Case 3: No trees.
            countOfTree = 0;
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    if(bfs(i))
                        countOfTree ++;
                }
            }
            if(countOfTree == 0) {
                sb.append("Case " + tc++ + ": No trees.");
            } else if(countOfTree == 1) {
                sb.append("Case " + tc++ + ": There is one tree.");
            } else {
                sb.append("Case " + tc++ + ": A forest of " + countOfTree + " trees.");
            }

            sb.append("\n");
        }
        System.out.println(sb);

    }
    //유니언파인드도 가능

    static boolean bfs(int s){

        //부분집합이 양방향 트리일 경우에는 (노드의 개수 - 1) * 2는 간선의 개수와 같다.
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        int node = 0, edge = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            node += 1;
            visited[cur] = true;

            for(int next : graph.get(cur)){
                edge ++;
                if(!visited[next])
                    q.add(next);
            }
        }

        return 2 * (node -1 ) == edge? true : false;

    }
}
