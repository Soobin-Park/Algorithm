import sys
from collections import deque

# 시간복잡도 : O(m * n)

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    global visited
    queue = deque()
    queue.append((x,y))
    # 현재 보는 구역의 넓이
    visited[x][y] = True
    temp = 1
    
    while queue:
        now_x, now_y = queue.popleft()
        visited[now_x][now_y] = True

        for i in range(4):
            next_x = now_x + dx[i]
            next_y = now_y + dy[i]

            if next_x >= m or next_x < 0 or next_y >= n or next_y <0:
                continue
            
            if not visited[next_x][next_y] and graph[next_x][next_y] == 1:
                visited[next_x][next_y] = True
                queue.append((next_x,next_y))
                temp +=1
    
    return temp

m, n, k = map(int, sys.stdin.readline().rstrip().split())
graph = [[1] * n for _ in range(m)]

for _ in range(k):
    l_x, l_y, r_x, r_y = map(int, sys.stdin.readline().rstrip().split())
    
    for i in range(l_x, r_x):
        for j in range(m - l_y - 1,m - r_y - 1, -1):
            graph[j][i] = 0
    
s_list = []
visited = [[False]* n for _ in range(m)]

for i in range(m):
    for j in range(n):
        if graph[i][j] != 0 and not visited[i][j]:
            s_list.append(bfs(i,j))

print(len(s_list))
print(*sorted(s_list))