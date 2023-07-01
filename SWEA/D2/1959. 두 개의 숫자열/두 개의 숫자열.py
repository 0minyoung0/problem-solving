T = int(input())
for test_case in range(1, T + 1) :
	n, m = map(int, input().split())
	max_num = 0
	if n == m :
		list_1 = list(map(int,input().split()))
		list_2 = list(map(int,input().split()))
		for j in range(n) :
			max_num += list_1[j] * list_2[j]
	else :
		if n > m :
			num_large = n
			num_small = m
			list_large = list(map(int, input().split()))
			list_small = list(map(int, input().split()))
		else :
			num_large = m
			num_small = n
			list_small = list(map(int, input().split()))
			list_large = list(map(int, input().split()))
		for i in range(num_large - num_small + 1) :
			if i == 0 :
				for j in range(num_small) :
					max_num += list_small[j] * list_large[j]
			else :
				temp_num = 0
				for j in range(num_small) :
					temp_num += list_small[j] * list_large[j+i]
				if temp_num > max_num :
					max_num = temp_num
	print(f"#{test_case} {max_num}")