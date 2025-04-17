package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_진우의달여행_17484 {

    static int n, m, res;
    static int[][] weights;
    static int[] dc = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weights= new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                weights[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;
        for (int j = 0; j <m; j++) {
            recur(0,j,-1,weights[0][j]);
        }

        System.out.println(res);



    }
    static void recur(int r, int c, int preDir, int sum){
        if(r == n-1){
            res = Math.min(res, sum);
            return;
        }

        for(int i = 0; i < 3; i++){
            if(preDir == i)
                continue;

            if(c+dc[i] < 0 || c+dc[i] >= m)
                continue;

            recur(r+1,c+dc[i],i,sum+weights[r+1][c+dc[i]]);

        }
    }
}
