import java.io.*;
import java.util.*;

public class Main {
    static int N, M, dotCount, ans;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        int caseNum = 1;

        while (input != null) {
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dotCount = 0;
            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '.') {
                        dotCount++;
                    }
                }
            }

            ans = Integer.MAX_VALUE;

            // 각 점을 시작점으로 map 돌리기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = '#';
                        bt(i, j, 1, 0);
                        map[i][j] = '.';
                    }
                }
            }

            if (ans == Integer.MAX_VALUE) {
                ans = -1;
            }
            System.out.println("Case " + caseNum + ": " + ans);

            input = br.readLine();
            caseNum++;
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    private static void bt(int curX, int curY, int curDotCount, int curMoveCount) {
        if (curDotCount == dotCount) {
            if (ans > curMoveCount) {
                ans = curMoveCount;
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = curX;
            int ny = curY;
            int additionalDotCount = 0;
            while (true) {
                nx += dx[dir];
                ny += dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != '.') {
                    nx -= dx[dir];
                    ny -= dy[dir];
                    break;
                }

                map[nx][ny] = '#';
                additionalDotCount++;
            }

            // 이동 실패한 경우
            if (nx == curX && ny == curY) {
                continue;
            }

            bt(nx, ny, curDotCount + additionalDotCount, curMoveCount + 1);

            while (true) {
                if (nx == curX && ny == curY) {
                    break;
                }

                map[nx][ny] = '.';
                nx -= dx[dir];
                ny -= dy[dir];
            }
        }
    }
}
