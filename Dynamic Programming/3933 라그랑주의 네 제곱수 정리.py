import sys
import math

flag = True

while flag:
    n = int(sys.stdin.readline().rstrip())
    temp_sum = 0

    if n == 0: 
        flag = False
        break

    #최대 4개 양의 제곱수의 합으로 만들 수 있는 경우의 수
    
    for i in range(1,int(math.sqrt(n))+1):
        if i*i == n:
            temp_sum+=1
            continue

        for j in range(i,int(math.sqrt(n))+1):
            if i*i + j*j == n:
                temp_sum +=1
                break
            elif i*i + j*j > n:
                break

            for k in range(j,int(math.sqrt(n))+1):
                if i*i + j*j + k*k == n:
                    temp_sum +=1
                    break
                elif i*i + j*j + k*k > n:
                    break
                for l in range(k,int(math.sqrt(n))+1):
                    if i*i + j*j + k*k +l*l == n:
                        temp_sum +=1
                        break
                    elif i*i + j*j + k*k +l*l> n:
                        break
                
    print(temp_sum)                        
