import sys
import heapq 

INF = sys.maxsize
V, E = map(int, sys.stdin.readline().rstrip().split())
k = int(sys.stdin.readline().rstrip())
#최소힙 써야하니까 무한으로 초기화
dist = [INF for _ in range(V+1)]
graph = [[] for _ in range(V+1)] 
heap = []

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().rstrip().split())
    graph[u].append((v,w))

def Dijkstra(start):
    dist[start] = 0
    heapq.heappush(heap,(start,0))

    while heap:
        now_v, now_w = heapq.heappop(heap)

        #저장되어있는 것보다 크다면 무시
        if dist[now_v] < now_w:
            continue

        #연결된 것 중
        for next_v, w in graph[now_v]: 
            next_w = now_w + w
            # 더 작은 가중치로 갈 수 있다면
            if dist[next_v] > next_w:
                dist[next_v] = next_w
                heapq.heappush(heap,(next_v,next_w))

Dijkstra(k)

for i in range(1,V+1):
    print("INF" if dist[i] == INF else dist[i])