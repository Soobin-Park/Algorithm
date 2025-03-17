package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_연속합2_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        int[] dp1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        //연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합 구하기
        //하나 이상 선택 (0 x)
        //하나 제거가능 (제거 안해도 됨)
        //제거 기준을 어떻게 할지.. -> 반대로 한 dp도 같이 고려하기
        //O(nlogn)으로 해야함
        dp1[0] = seq[0];
        int result = seq[0];

        //오른쪽 DP
        for(int i=1; i<n; i++){
            dp1[i] = Math.max(dp1[i-1]+seq[i],seq[i]);
            result = Math.max(result,dp1[i]);
        }

        //왼쪽 DP
        int[] dp2 = new int[n];
        dp2[n-1] = seq[n-1];
        for(int i=n-2;i>=0;i--){
            dp2[i] = Math.max(dp2[i+1]+seq[i],seq[i]);

        }

        for(int i=1;i<n-1;i++){
            //i번째 값이 빠졌다고 하고 봐보기
            int dpSum = dp1[i-1]+ dp2[i+1];
            result = Math.max(result,dpSum);

        }
        System.out.println(result);

    }
}
