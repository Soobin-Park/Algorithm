import sys
from collections import deque

t = int(sys.stdin.readline().rstrip())

dx = [-2,-1,1,2,2,1,-1,-2]
dy = [1,2,2,1,-1,-2,-2,-1]

def bfs (start_x,start_y):
    global finish_x,finish_y
    graph = [[0] *l for _ in range(l)]
    queue = deque()
    queue.append((start_x,start_y))

    #최소 이동 횟수 -> 그래프에 저장! + visited도 같이

    while queue:
        now_x,now_y = queue.popleft()
        
        if now_x == finish_x and now_y == finish_y:
            return graph[now_x][now_y]

        for i in range(8):
            next_x, next_y = now_x + dx[i], now_y + dy[i]

            if next_x < 0 or next_x >= l or next_y < 0 or next_y >= l:
                continue

            if graph[next_x][next_y] ==0:
                graph[next_x][next_y] = graph[now_x][now_y] +1
                queue.append((next_x,next_y))

for _ in range(t):
    l = int(sys.stdin.readline().rstrip())
    knight_x, knight_y = map(int,sys.stdin.readline().rstrip().split())
    finish_x, finish_y = map(int,sys.stdin.readline().rstrip().split())

    print(bfs(knight_x,knight_y))