import java.io.*;
import java.util.*;

public class Main {
    static int R, C, D, W;
    static int[] assign;
    static int[] done;
    static int[][] y;
    static List<int[]> list0 = new ArrayList<>();
    static Map<Integer, Integer> c2i1 = new HashMap<>();
    static int size;
    static int run;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 1 <= R <= 50
        C = Integer.parseInt(st.nextToken()); // 1 <= C <= 50
        D = Integer.parseInt(st.nextToken()); // 1 <= D <= 1_000_000_000
        W = Integer.parseInt(st.nextToken()); // 1 <= W <= 1_000_000_000

        Map<Integer, Integer> yCountMap = new HashMap<>();

        y = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                y[i][j] = Integer.parseInt(st.nextToken());
                yCountMap.put(y[i][j], yCountMap.getOrDefault(y[i][j], 0) + 1);
            }
        }
        yCountMap.put(0, 0);

        List<Integer> yList = new ArrayList<>(yCountMap.keySet());
        Collections.sort(yList);

        // 공원을 지을 땅의 개수
        int count = R * C;

        // yList 내의 값을 Z 값으로 하면서 비용 시뮬레이션
        long ans = Long.MAX_VALUE;
        for (int Z : yList) {
            count -= yCountMap.get(Z);
            // 공원을 지어야 하는 땅이 홀수개면 continue
            if (count % 2 == 1) {
                continue;
            }

            // 기계산된 ans보다 시뮬레이션 성공시 비용이 크거나 같은 경우 continue
            long cost = (long) D * count / 2 + (long) Z * W;
            if (ans <= cost) {
                continue;
            }

            list0.clear();
            c2i1.clear();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (y[i][j] <= Z) {
                        continue;
                    }
                    int coor = i * C + j;
                    if ((i + j) % 2 == 0) {
                        list0.add(new int[] { i, j });
                    } else {
                        c2i1.put(coor, c2i1.size());
                    }
                }
            }
            // list0, c2i1의 사이즈가 다른 경우 continue
            if (list0.size() != c2i1.size()) {
                continue;
            }
            size = list0.size();

            // 이분 매칭을 통해 최대 유량 (= 지을 수 있는 공원의 수) 확인
            int max = 0;
            assign = new int[size];
            Arrays.fill(assign, -1);
            done = new int[size];
            Arrays.fill(done, -1);
            for (int i = 0; i < size; i++) {
                run = i;
                if (dfs(i)) {
                    max++;
                }
            }

            // 최대 유량(= 공원의 수) 값이 list0.size()와 일치하는 경우 ans 갱신
            if (max == size) {
                ans = cost;
            }
        }

        System.out.print(ans);
    }

    private static boolean dfs(int idx) {
        int[] cur = list0.get(idx);
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur[0] + dx[dir];
            int ny = cur[1] + dy[dir];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || !c2i1.containsKey(nx * C + ny)) {
                continue;
            }
            int nIdx = c2i1.get(nx * C + ny);
            if (done[nIdx] == run) {
                continue;
            }
            done[nIdx] = run;
            if (assign[nIdx] == -1 || dfs(assign[nIdx])) {
                assign[nIdx] = idx;
                return true;
            }
        }

        return false;
    }
}
