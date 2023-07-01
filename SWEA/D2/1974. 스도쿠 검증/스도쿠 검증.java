T = int(input())
for test_case in range(1, T + 1) :
    isperfect = 1
    arr = [list(map(int, input().split())) for _ in range (9)]
    for i in range(9) :
        temp_arr = sorted(arr[i])
        if temp_arr != [1,2,3,4,5,6,7,8,9] :
            isperfect = 0
            break
    if isperfect == 0 :
        print(f"#{test_case} 0")
        continue
    for i in range(9) :
        temp_arr = sorted([line[i] for line in arr])
        if temp_arr != [1,2,3,4,5,6,7,8,9] :
            isperfect = 0
            break
    if isperfect == 0 :
        print(f"#{test_case} 0")
        continue
    for i in range(3) :
        for j in range(3) :
            temp_arr = []
            for k in range(3) :
                for l in range(3) :
                    temp_arr.append(arr[3*i+k][3*j+l])
            temp_arr.sort()
            if temp_arr != [1,2,3,4,5,6,7,8,9] :
                isperfect = 0
                break
        if isperfect == 0 :
            break
    if isperfect == 0:
        print(f"#{test_case} 0")
    else :
        print(f"#{test_case} 1")