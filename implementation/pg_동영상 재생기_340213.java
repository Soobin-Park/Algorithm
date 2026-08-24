import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        //현재 분, 초 추출 (String -> int)
        //10초 전 이동인 경우 00:00보다 적어지는 경우 추가
        //10초 후 이동인 경우 영상 길이를 넘는 경우 추가
        
        //초로 바꿔서 연산해야함 초가 작아서 조건에 안걸리는 경우가 생김
        
        int video = toSecond(video_len);
        int now = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);
 
        
        for(int i=0;i<commands.length;i++){
        //3.오프닝 건너뛰기 -> 현재 재생위치가 op_start 이상 op_end 이하인 경우 자동으로 오프닝이 끝나는 위치로 이동
            if(now >= opStart && now <= opEnd)
                now = opEnd;           
                        
        //1.10초전이동 "prev"       
            if( commands[i].equals("prev") ){
                now -= 10;
                
                //현재 위치가 10초 미만인 경우엔 처음 위치
            if(now < 0)
                now = 0;
            }

        //2.10초후이동 "next" 
            else if( commands[i].equals("next") ){
                now += 10;
            
                //남은 시간이 10초 미만인 경우 마지막 위치
                if(now > video)
                    now = video;
            }                     
        //3.오프닝 건너뛰기 -> 현재 재생위치가 op_start 이상 op_end 이하인 경우 자동으로 오프닝이 끝나는 위치로 이동            
            if(now >= opStart && now <= opEnd)
                now = opEnd;
        }
        
        int minute = now / 60;
        int second = now % 60;
        
        return String.format("%02d:%02d", minute, second);
    }
    
    private int toSecond(String time){
        String[] arr = time.split(":");
        
        int minute = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[1]);
        
        return minute * 60 + second;
    }
}
