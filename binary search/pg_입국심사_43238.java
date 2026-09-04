import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        //모든 사람 심사 받는데 걸리는 시간 최소
        //심사대마다 심사하는 시간이 달라서, 비는 곳으로 바로바로 넣는게 답이 x
        //이분탐색을 어디서 쓰라는건지 감도안옴
        //1~가장긴심사대*n 으로 시간 이분탐색
        //시간 골라서 되는지 안되는지 시행
        long max = times[0];

        for (int time : times) {
            max = Math.max(max, time);
        } 
        
        long start = 1;
        long end = max * n;
        long count = 0;
        long mid;
        
        while(start <= end){
            mid = (start + end) / 2;
            count = 0;
            
            for(int time : times){
                count += mid / time;
            }
            
            if(count >=n){
                end = mid -1;
            } else {
                start = mid + 1;
            }
            
        }
        
        return start;
    }
}
