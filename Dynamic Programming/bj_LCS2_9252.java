package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_LCS2_9252 {
    public static void main(String[] args) throws IOException {
        //연속 아니어도 되어야 함 + 대문자 알파벳으로만 구성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String seq1 = br.readLine();
        String seq2 = br.readLine();

        int[][] dp = new int[seq1.length()+1][seq2.length()+1];
        for (int i = 0; i <= seq1.length(); i++) {
            for (int j = 0; j <= seq2.length(); j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= seq1.length(); i++) {
            for (int j = 1; j <= seq2.length(); j++) {
                if (seq1.charAt(i-1) == seq2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                //같지 않으면 더 긴 걸로 갱신
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        System.out.println(dp[seq1.length()][seq2.length()]);

        //문자열 복원 (거꾸로)
        //처음부터 dp를 String으로 하면 메모리초과

        StringBuilder sb = new StringBuilder();
        int i = seq1.length();
        int j = seq2.length();

        while(i > 0 && j > 0){
            //같으면 추가
            if(seq1.charAt(i-1) == seq2.charAt(j-1)){
                sb.append(seq1.charAt(i-1));
                i--;
                j--;
                //긴쪽 인덱스를 빼주기
            }else if(dp[i][j - 1] > dp[i - 1][j]){
                j--;
            }else{
                i--;
            }


        }
        System.out.println(sb.reverse());

    }
}
