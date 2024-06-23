import sys
sys.setrecursionlimit(10**9)

def dfs(start, end, dist):
    global count
    if start == end :
        count = dist
        return
    
    for node, r in graph[start]:
        if not visited[node]:
            visited[node] = True
            dfs(node, end, dist + r)

n, m = map(int,sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    cur, next, r = map(int,sys.stdin.readline().rstrip().split())
    graph[cur].append([next,r])
    graph[next].append([cur,r])

for _ in range(m):
    cur, next = map(int,sys.stdin.readline().rstrip().split())
    visited = [False for _ in range(n+1)]
    count = 0
    visited[cur] = True
    dfs(cur, next, 0)
    print(count)
