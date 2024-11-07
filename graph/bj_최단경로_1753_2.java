package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_최단경로_1753_2 {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < V+1; i++)
            graph.add(new ArrayList<>());
        weight = new int[V + 1];
        Arrays.fill(weight, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }
        dijkstra(K);
        for (int i = 1; i < V + 1; i++) {
            if (weight[i] == INF)
                sb.append("INF");
            else
                sb.append(weight[i]);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        weight[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nowNode= cur.node;
            int nowWeight = cur.weight;

            //저장된 것보다 꺼낸 게 크면 무시
            if(weight[nowNode] < nowWeight)
                continue;

            for(Node next:graph.get(nowNode)){
                int nextWeight = nowWeight + next.weight;

                //다음 노드 가중치 저장된 거보다 지금 계산한게 작으면 업데이트
                if(nextWeight< weight[next.node]){
                    weight[next.node] = nextWeight;
                    pq.add(new Node(next.node, nextWeight));
                }
            }

        }

    }

    static class Node implements Comparable<Node>{
        int node;
        int weight;

        Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight,other.weight);
        }

    }


}
