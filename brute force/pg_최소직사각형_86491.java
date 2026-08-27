import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        //모든 명함을 넣을 수 있는 최소한의 직사각형

        for(int i=0;i<sizes.length;i++){
            int curW = sizes[i][0];
            int curH = sizes[i][1];
            
            //긴 변 가로, 짧은 변 세로로 통일
            int longSide = Math.max(curW,curH);
            int shortSide = Math.min(curW,curH);
            
            maxW = Math.max(maxW, longSide);
            maxH = Math.max(maxH, shortSide);

        }
        
        return maxW * maxH;
    }
}
