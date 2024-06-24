import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    parentList = [0 for _ in range(n+1)]
    for _ in range(n-1):
        a, b = map(int, sys.stdin.readline().rstrip().split())
        parentList[b] = a

    a, b = map(int, sys.stdin.readline().rstrip().split())
    aParents, bParents = [a], [b]
    #각각의 부모들을 저장해두기
    while parentList[a]:
        aParents.append(parentList[a])
        a = parentList[a]
    
    while parentList[b]:
        bParents.append(parentList[b])
        b = parentList[b]
    
    flag = False
    for i in range(len(aParents)):
        for j in range(len(bParents)):
            if aParents[i] == bParents[j]:
                print(aParents[i])
                flag = True
                break
        if flag:
            break