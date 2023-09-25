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
        parent = new int[N];
        for (int i=0; i<N; i++) {
            parent[i] = i;
        }

        double[][] coor = new double[N][2];
        for (double[] c : coor) {
            st = new StringTokenizer(br.readLine());
            c[0] = Double.parseDouble(st.nextToken());
            c[1] = Double.parseDouble(st.nextToken());
        }

        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                list.add(new double[] {
                    Math.sqrt(Math.pow(coor[i][0] - coor[j][0], 2) + Math.pow(coor[i][1] - coor[j][1], 2)), i, j}
                );
            }
        }
        Collections.sort(list, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                for (int i=0; i<3; i++) {
                    if (o1[i] < o2[i])
                        return -1;
                    if (o1[i] > o2[i])
                        return 1;
                }
                return 0;
            }
        });

        int cnt = 0;
        double ans = 0;
        for (double[] e : list) {
            if (union((int)e[1], (int)e[2])) {
                ans += e[0];
                if (++cnt == N-1) break;
            }
        }
        System.out.printf("%.2f", ans);

    }
    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        parent[Math.max(x, y)] = Math.min(x, y);
        return true;
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}