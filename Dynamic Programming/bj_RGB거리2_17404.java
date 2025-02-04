package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_RGB거리2_17404 {
    static int n, answer;
    static int[][] cost, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //R G B
        cost = new int[n][3];
        //dp = new int[n+1][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //System.out.println(Integer.min(Integer.min(recur(0, 0,0),recur(0,1,1)),recur(0,2,2)));

        answer = 1000 * n;
        for (int start = 0; start < 3; start++) {
            dp = new int[n][3];
            for (int[] row : dp) Arrays.fill(row, -1); // DP 초기화
            answer = Integer.min(answer, recur(1, start, start) + cost[0][start]);
        }

        System.out.println(answer);

    }
    static int recur(int cur,int pre, int start){
        //인접한 집의 색이 같으면 안됨
        if(cur == n){
            return 0;
        }
        if(dp[cur][pre] !=-1)
            return dp[cur][pre];

        //나올 수 있는 최대치
        int ret = 1000 * n;
        for(int i=0;i<3;i++){
            if(cur == n-1 && i == start)
                continue;
            if( i == pre)
                continue;

            //모든 경우 다녀오고 최소
            ret = Integer.min(ret,recur(cur+1,i,start)+cost[cur][i]);
        }

        dp[cur][pre] = ret;
        return dp[cur][pre];


    }
}