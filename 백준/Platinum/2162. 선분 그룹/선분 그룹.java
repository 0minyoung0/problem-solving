import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        int[][] line = new int[N+1][4];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<4; j++) {
                line[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<N; i++) {
            for (int j=i+1; j<=N; j++) {
                if (crossCheck(line[i], line[j])) {
                    union(i, j);
                }
            }
        }
        // 경로 압축!!!
        for (int i=1; i<N; i++) {
            for (int j=i+1; j<=N; j++) {
                if (crossCheck(line[i], line[j])) {
                    union(i, j);
                }
            }
        }

        // 개수 세기
        int ans1 = 0;
        int ans2 = 0;
        int[] cnt = new int[N+1];
        for (int i=1; i<=N; i++) {
            if (cnt[parent[i]] == 0) {
                ans1++;
            }
            if (++cnt[parent[i]] > ans2) {
                ans2 = cnt[parent[i]];
            }
        }
        System.out.print(ans1 + "\n" + ans2);
    }

    private static void union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);
        if (n1 != n2) parent[Math.max(n1, n2)] = Math.min(n1, n2);
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static boolean crossCheck(int[] line1, int[] line2) {
        return crossCheck(line1[0], line1[1], line1[2], line1[3], line2[0], line2[1], line2[2], line2[3]);
    }

    private static boolean crossCheck(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int ccw1 = CCW(x1, y1, x2, y2, x3, y3);
        int ccw2 = CCW(x1, y1, x2, y2, x4, y4);
        int ccw3 = CCW(x3, y3, x4, y4, x1, y1);
        int ccw4 = CCW(x3, y3, x4, y4, x2, y2);
        // 선분이 겹치지 않고 교차하는 경우
        if ((ccw1 != 0 || ccw2 != 0) && ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            return true;
        }
        // 선분이 겹치는 경우
        if (ccw1 == 0 && ccw2 == 0) {
            // x축에 평행한 경우
            if (y1 == y2) {
                if ((x1 <= x3 || x1 <= x4 || x2 <= x3 || x2 <= x4)
                && (x1 >= x3 || x1 >= x4 || x2 >= x3 || x2 >= x4)) {
                    return true;
                }
            }
            // x축에 평행하지 않은 경우
            else {
                if ((y1 <= y3 || y1 <= y4 || y2 <= y3 || y2 <= y4)
                && (y1 >= y3 || y1 >= y4 || y2 >= y3 || y2 >= y4)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 점 A (x1, y1), 점 B (x2, y2), 점 C (x3, y3)에 대하여 벡터 AB, 벡터 AC의 CCW 계산
     */
    private static int CCW (int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = (long) (x2 - x1) * (y3 - y1) - (long) (x3 - x1) * (y2 - y1);
        return result < 0 ? -1 : result > 0 ? 1 : 0;
    }
}