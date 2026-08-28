import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char num : number.toCharArray()){
            
            //지금 숫자가 더 크다면
            //앞에 있는 작은 수 제거
            while(!stack.isEmpty() && k>0 && stack.peekLast() <num){
                stack.pollLast();
                k--;
            } 
            stack.addLast(num);
        }

        // 아직 제거해야 할 숫자가 남아 있다면
        // 뒤에서부터 제거
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        // 스택에 남은 숫자를 문자열로 변환
        StringBuilder answer = new StringBuilder();

        for (char num : stack) {
            answer.append(num);
        }

        return answer.toString();
    }
}
