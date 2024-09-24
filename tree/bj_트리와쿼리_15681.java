package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_트리와쿼리_15681 {
    static int n, r, q;
    static int[] parent, size;
    static List<Integer>[] list, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        size = new int[n+1];
        list = new ArrayList[n+1];
        tree = new ArrayList[n+1];

        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st =new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        makeTree(r,-1);
        countSubtreeNodes(r);

        //O(n+q)
        for(int i=0;i<q;i++){
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append("\n");
        }
        System.out.println(sb);

    }
    static void makeTree(int cur, int p){
        //입력 리스트, 루트 바탕으로 트리 구성하기 
        for(int node : list[cur]){
            // cur의 부모(p)와 다르면
            if(node != p){
                //cur의 자식에 추가 
                tree[cur].add(node);
                //부모 표시
                parent[node] = cur;
                //자식도 트리만들기
                makeTree(node,cur);
            }
        }
    }

    static void countSubtreeNodes(int cur){
        // 자신도 자신을 루트로 하는 서브트리에 포함되므로 0이 아닌 1에서 시작한다.
        size[cur] = 1;

        for(int node :tree[cur]){
            countSubtreeNodes(node);
            //서브트리 사이즈 더해주기
            //나 + 자식
            size[cur] += size[node];
        }
    }

}
