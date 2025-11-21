import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            List<int[]> coordinate = new ArrayList<>();

            int[][] A = new int[R][C];
            for (int i = 0; i < R; i++) {
                Arrays.fill(A[i], -1);
            }
            A[r][c] = 0; // 목적지 (0)
            coordinate.add(new int[] { r, c });

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;
                A[X][Y] = i; // 게임말 (1 ~ N)
                coordinate.add(new int[] { X, Y });
            }

            int M = 0; // 벽 개수
            for (int i = 0; i < R; i++) {
                String row = br.readLine();
                for (int j = 0; j < C; j++) {
                    char ch = row.charAt(j);
                    if (ch == 'W') {
                        A[i][j] = coordinate.size(); // 벽 (N+1 ~ N+M)
                        coordinate.add(new int[] { i, j });
                        M++;
                    }
                }
            }

            // r, c에서 BFS 수행
            int[][] disFromH = new int[R][C];
            for (int i = 0; i < R; i++) {
                Arrays.fill(disFromH[i], -1);
            }
            Queue<int[]> q = new ArrayDeque<>();

            disFromH[r][c] = 0;
            q.offer(new int[] { r, c });

            int[] dx = new int[] { -1, 1, 0, 0 };
            int[] dy = new int[] { 0, 0, -1, 1 };

            long ans1 = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    boolean isOutOfBound = nx < 0 || nx >= R || ny < 0 || ny >= C;
                    if (isOutOfBound) {
                        continue;
                    }
                    boolean isVisited = disFromH[nx][ny] >= 0;
                    if (isVisited) {
                        continue;
                    }

                    int index = A[nx][ny];
                    disFromH[nx][ny] = disFromH[cur[0]][cur[1]] + 1;

                    boolean isWall = index > N;
                    if (!isWall) {
                        q.offer(new int[] { nx, ny });
                    }
                    boolean isPiece = index >= 1 && index <= N;
                    if (isPiece) {
                        ans1 += disFromH[nx][ny];
                    }
                }
            }

            long ans2 = 0;
            // 각 게임말에서 BFS 수행
            for (int p = 1; p <= N; p++) {
                int[][] disFromP = new int[R][C];
                for (int i = 0; i < R; i++) {
                    Arrays.fill(disFromP[i], -1);
                }

                int px = coordinate.get(p)[0];
                int py = coordinate.get(p)[1];

                disFromP[px][py] = 0;
                q.offer(new int[] { px, py });

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        boolean isOutOfBound = nx < 0 || nx >= R || ny < 0 || ny >= C;
                        if (isOutOfBound) {
                            continue;
                        }
                        boolean isVisited = disFromP[nx][ny] >= 0;
                        if (isVisited) {
                            continue;
                        }

                        int index = A[nx][ny];
                        disFromP[nx][ny] = disFromP[cur[0]][cur[1]] + 1;

                        boolean isWall = index > N;
                        if (!isWall) {
                            q.offer(new int[] { nx, ny });
                        } else {
                            // 목적지에서 도달 불가능한 경우
                            if (disFromH[nx][ny] == -1) {
                                continue;
                            }

                            int disUsingWall = disFromH[nx][ny] + disFromP[nx][ny];
                            // 벽을 통한 거리가 더 작은 경우
                            if (disUsingWall < disFromH[px][py]) {
                                ans2 += (disFromH[px][py] - disUsingWall);
                            }
                        }
                    }
                }
            }
            sb.append(ans1).append(' ').append(ans2).append('\n');
        }
        System.out.print(sb);
    }
}
