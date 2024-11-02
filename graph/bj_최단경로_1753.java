package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_최단경로_1753 {

    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] != INF)
                sb.append(dist[i]).append("\n");
            else
                sb.append("INF").append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        dist[start] = 0;
        heap.offer(new Node(start, 0));


        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int nowNode = cur.node;
            int nowDist = cur.weight;

            //저장된 것보다 가중치가 크면 무시
            if (dist[nowNode] < nowDist)
                continue;

            for(Node next : graph.get(nowNode)){
                int nextDist = nowDist + next.weight;

                //지금 계산한 다음 노드의 가중치가 저장된 거보다 작으면 업데이트
                if(nextDist < dist[next.node]){
                    dist[next.node] = nextDist;
                    heap.offer(new Node(next.node, nextDist));
                }

            }

        }


        }

        static class Node implements Comparable<bj_최단경로_1753.Node>{
            int node;
            int weight;

            Node(int node, int weight) {
                this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }

    }

}

