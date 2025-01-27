package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node> {

    int start;
    int end;
    int cost;

    public node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(node o) {
        return this.cost - o.cost;
    }
}

//MST
//크루스칼
public class bj_도시분할계획_1647 {
    static int n, m;
    static int[] parent;
    static long result;
    static int maxCost;
    static PriorityQueue<node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new node(a, b, c));
        }

        // 두 마을로 분리
        // 각 마을안에서 다 이어져있기만 하면 됨
        // 유지비 최소

        //최소비용으로 다 이어주기
        while(!pq.isEmpty()){
            node now = pq.poll();
            if(find(now.start) != find(now.end)){
                union(now.start, now.end);
                result += now.cost;
                maxCost = now.cost;

            }

        }
        //가장 큰 유지비용 제거
        System.out.println(result - maxCost);

    }

    static int find(int x){
        if(x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);

    }

    static void union(int x, int y){

        int xp = find(x);
        int yp = find(y);

        if(xp < yp)
            parent[yp] = xp;
        else
            parent[xp] = yp;
    }
}
