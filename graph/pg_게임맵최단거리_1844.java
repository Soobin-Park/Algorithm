import java.io.*;
import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        //bfs
        //상하좌우 1칸씩 막힌길존재
        //캐릭터가 상대팀 진영(n,m)에 도착하기 위해 지나가야하는 칸의 개수 최솟값
        //도착 불가능하면 -1 
        //0이 벽이 있는자리 1은 벽이 없는 자리(갈 수 있는 길)
        //1,1이 처음 시작 
        
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        
        q.offer(new int[]{0,0});
        //최단거리 visited에 저장 !!
        visited[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int r = cur[0];
            int c = cur[1];
            
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr > n-1 || nc < 0 || nc > m-1 )
                    continue;
                
                if(visited[nr][nc] != 0 || maps[nr][nc] == 0)
                    continue;
                
                //q에 넣을 때 방문처리 권장
                visited[nr][nc] = visited[r][c] + 1;
                q.offer(new int[]{nr, nc});
                
            }
        }
        
        if (visited[n - 1][m - 1] == 0)
            return -1;
        else
            return visited[n - 1][m - 1];
    }
}
