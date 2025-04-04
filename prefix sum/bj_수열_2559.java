package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_수열_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] seq = new int[n];
        int[] prefixSum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            prefixSum[i+1] = prefixSum[i] + seq[i];
        }
        
        int res = -100*k;
        for(int i = 0; i <= n-k; i++){
            res = Math.max(res, prefixSum[k+i] - prefixSum[i]);
        }

        System.out.println(res);



    }
}
