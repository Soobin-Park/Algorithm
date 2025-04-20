

package baekjoon;
import java.io.*;
public class bj_리그오브레전설_17271 {


        static final int MOD = 1_000_000_007;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            int[] dp = new int[n + 1];
            dp[0] = 1;  // 아무것도 선택하지 않는 경우

            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                if (i >= m) {
                    dp[i] = (dp[i] + dp[i - m]) % MOD;
                }
            }

            System.out.println(dp[n]);
        }
    }
}
