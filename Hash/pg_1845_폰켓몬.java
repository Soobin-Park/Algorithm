import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        //n개. 중복되어 들어있음
        int answer;
        //n/2마리를 고를 때 선택되는 가장 많은 종류의 수
        
        int n = nums.length;
        
        Map<Integer,Integer> ponkemon = new HashMap<>();
        //key의 수와 n/2을 비교하면 될 듯
        
        for(int i=0; i<n;i++){
            ponkemon.put(nums[i],ponkemon.getOrDefault(nums[i],0) +1);
        }
        
        if(n/2 >=  ponkemon.size())
            answer = ponkemon.size();
        else
            answer = n/2;
        
        return answer;
    }
}
