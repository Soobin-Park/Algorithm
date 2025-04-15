package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_포도주시식_2156 {
    static int n;
    static int[] dp, wines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        wines = new int[n+1];

        for(int i = 1; i <= n; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        if (n >= 1) {
            dp[1] = wines[1];
        }

        if (n >= 2) {
            dp[2] = wines[1] + wines[2];
        }

        for (int i = 3; i <= n; i++) {
            //i-1을 먹었거나 안먹었거나
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 3] + wines[i - 1] + wines[i],
                            dp[i - 2] + wines[i]));
        }

        System.out.println(dp[n]);
    }

}
