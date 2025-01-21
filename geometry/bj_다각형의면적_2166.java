package baekjoon;

import java.io.*;
import java.util.*;

public class bj_다각형의면적_2166 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dots = new int[n][2];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            dots[i][0]=Integer.parseInt(st.nextToken());
            dots[i][1]=Integer.parseInt(st.nextToken());
        }

        double sum = 0;
        //공식이 있음
        for(int i=0;i<n;i++){
            sum += (double) dots[i][0] * dots[(i+1)%n][1];
            sum -= (double) dots[i][1] * dots[(i+1)%n][0];
        }

        System.out.printf("%.1f", Math.abs(sum/2));

    }
}
