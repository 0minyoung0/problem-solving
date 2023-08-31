import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        List<int[]> edges = new ArrayList<>();

        // 테스트 케이스 별로 실행
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            // 도시의 수
            int N = Integer.parseInt(st.nextToken());
            // 길의 수
            int M = Integer.parseInt(st.nextToken());
            // 도로를 지어도 되는지 판단해야하는 두 도시
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            for (int i=1; i<=N; i++) {
                parent[i] = i;
            }

            int roadCost = -1;

            // 도로 정보
            edges.clear();
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges.add(new int[] {w, u, v});
                if ((u == p && v == q) || (u == q && v == p)) roadCost = w;
            }
            Collections.sort(edges, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) return o1[0] - o2[0];
                    if (o1[1] != o2[1]) return o1[1] - o2[1];
                    return o1[2] - o2[2];
                }
            });

//            if (roadCost == -1) System.out.println("NO");

            // 최소 비용 구하기
            int cnt = N - 1;
            long cost = 0;
            for (int[] e : edges) {
                if (!union(e[1], e[2])) continue;
                cost += e[0];
                if (--cnt == 0) break;
            }

            // p와 q 사이 도로를 반드시 짓는 경우
            for (int i=1; i<=N; i++) {
                parent[i] = i;
            }
            cost -= roadCost;
            union(p, q);
            cnt = N - 2;
            for (int[] e : edges) {
                if (!union(e[1], e[2])) continue;
                cost -= e[0];
                if (--cnt == 0) break;
            }

            if (cost < 0) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        parent[Math.max(x, y)] = Math.min(x, y);
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}