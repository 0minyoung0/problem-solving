for test_case in range(10):
    test_num = int(input())
    num_list = [list(map(int, input().split())) for _ in range(100)]
    sum_max = 0
    for i in range(100):
        sum_max += num_list[i][i]
    sum_cur = 0
    for i in range(100):
        sum_cur += num_list[i][99-i]
    if sum_cur > sum_max:
        sum_max = sum_cur
    for i in range(100):
        sum_cur = sum(num_list[i])
        if sum_cur > sum_max:
            sum_max = sum_cur
    for i in range(100):
        sum_cur = sum([line[i] for line in num_list])
        if sum_cur > sum_max:
            sum_max = sum_cur
    print(f"#{test_num} {sum_max}")