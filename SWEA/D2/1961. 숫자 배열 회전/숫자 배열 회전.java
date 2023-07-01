T = int(input())
for test_case in range(1, T + 1):
	n = int(input())
	arr = [list(map(int, input().split())) for _ in range (n)]
	print(f"#{test_case}")
	for i in range(n) :
		for j in range(n) :
			print(arr[n-1-j][i], end="")
		print(" ", end="")
		for j in range(n) :
			print(arr[n-1-i][n-1-j], end="")
		print(" ", end="")
		for j in range(n) :
			print(arr[j][n-1-i], end="")
		print("")