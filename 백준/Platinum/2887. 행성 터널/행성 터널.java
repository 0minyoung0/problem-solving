import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        List<int[]>[] data = new List[3];
        for (int i = 0; i < 3; i++) {
            data[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[j].add(new int[]{Integer.parseInt(st.nextToken()), i});
            }
        }
        for (int i = 0; i < 3; i++) {
            Collections.sort(data[i], new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                list.add(new int[]{data[j].get(i)[0] - data[j].get(i - 1)[0], data[j].get(i)[1],
                        data[j].get(i - 1)[1]});
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[2] - o2[2];
            }
        });

        long cost = 0;
        int cnt = 0;
        for (int[] e : list) {
            if (!union(e[1], e[2])) {
                continue;
            }
            cost += e[0];
            if (++cnt == N - 1) {
                break;
            }
        }
        System.out.print(cost);
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
