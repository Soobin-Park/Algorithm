import sys
import heapq
#O(nlogn)

n = int(sys.stdin.readline().rstrip())
lectures = []

for _ in range(n):  
    lectures.append(list(map(int,sys.stdin.readline().rstrip().split())))

lectures.sort()

# 끝나는 시간을 넣는다.
heap = [lectures[0][1]]

for i in range(1, n):
    # 강의 중 가장 빨리 끝나는 시간이 다른 강의의 시작시간보다 이하라면
    # (같은 강의실을 사용할 수 있다면)
    if heap[0] <= lectures[i][0]:
        heapq.heappop(heap)
    
    # 새로 끝나는 강의 추가 
    heapq.heappush(heap,lectures[i][1])

# 남는 강의들의 개수
print(len(heap))
