def distance(x1, y1, x2, y2):
    return abs(x1 - x2) + abs(y1 - y2)

def cal_dis(idx):
    dis = distance(x_s, y_s, x[idx[0]], y[idx[0]]) + distance(x[idx[N - 1]], y[idx[N - 1]], x_d, y_d)
    for i in range(N - 1):
        dis += distance(x[idx[i]], y[idx[i]], x[idx[i + 1]], y[idx[i + 1]])
    return dis

def next_permutation(idx):
    for i in range(N - 1, 0, -1):
        if idx[i] > idx[i - 1]:
            j = N - 1
            while(idx[i - 1] >= idx[j]):
                j -= 1
            idx[i - 1], idx[j] = idx[j], idx[i - 1]
            idx = idx[:i] + sorted(idx[i:])
            return idx

def answer(idx):
    ans = cal_dis(idx)
    end = sorted(idx, reverse = True)
    while idx != end:
        idx = next_permutation(idx)
        ans = min(ans, cal_dis(idx))
    return ans

T = int(input())
for case_num in range(1, T + 1):
    N = int(input())
    user_input = list(map(int,input().split()))
    x_s, y_s = user_input[0], user_input[1]
    x_d, y_d = user_input[2], user_input[3]
    x = []
    y = []
    idx = []
    for i in range(N):
        x.append(user_input[2 * i + 4])
        y.append(user_input[2 * i + 5])
        idx.append(i)
    print(f"#{case_num} {answer(idx)}")