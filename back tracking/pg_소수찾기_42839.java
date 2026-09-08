import java.io.*;
import java.util.*;

class Solution {
    boolean[] visited;
    Set<Integer> numsSet = new HashSet<>();
    String numbers;
    
    public int solution(String numbers) {
        int answer = 0;
        this.numbers = numbers;
        
        visited = new boolean[numbers.length()];
        //만들 수 있는 수 생성 -> set으로 중복제거
        dfs("");
        
        //소수체크
        for(int num : numsSet){
            if(isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    private void dfs(String cur){
        
        //현재까지 만든 숫자 넣기
        if(!cur.equals(""))
            numsSet.add(Integer.parseInt(cur));
        
        for(int i=0;i<numbers.length();i++){
            if(visited[i])
                continue;
            visited[i] = true;
            
            String next = cur + numbers.charAt(i);
            dfs(next);
            visited[i] = false;
        }             
    }
    
    private boolean isPrime(int num){
        if(num < 2)
            return false;
        //합성수의 약수는 짝으로 있으니 분기점까지보면됨
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
