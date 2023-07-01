from collections import deque

def bfs (x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    queue = deque()
    queue.append((x, y))
    visited = [[0] * 100 for _ in range(100)]
    visited[x][y] = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= 100 or ny <0 or ny >= 100:
                continue
            if maze[nx][ny] == '3':
                return 1
            if maze[nx][ny] == '1' or visited[nx][ny] == 1:
                continue
            else:
                queue.appendleft((nx, ny))
                visited[nx][ny] = 1
    return 0

for test_case in range(1, 11):
    case_num = int(input())
    maze = []
    for _ in range(100):
        maze.append(input())
    for i in range(100):
        for j in range(100):
            if maze[i][j] == '2':
                start_x, start_y = i, j
            elif maze[i][j] == '3':
                end_x, end_y = i, j
    print(f"#{case_num} {bfs(start_x, start_y)}")