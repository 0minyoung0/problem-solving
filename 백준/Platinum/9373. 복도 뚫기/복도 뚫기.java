import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        DecimalFormat df = new DecimalFormat("0.######");

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int w = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                System.out.println(df.format((double) w / 2));
                continue;
            }

            parent = new int[n + 2];
            for (int i = 0; i < n + 2; i++) {
                parent[i] = i;
            }

            int[][] points = new int[n][3];
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = points[i][0] = Integer.parseInt(st.nextToken());
                int y = points[i][1] = Integer.parseInt(st.nextToken());
                int r = points[i][2] = Integer.parseInt(st.nextToken());

                if (x > r) {
                    edges.add(new Edge(i, n, x - r));
                } else {
                    union(i, n);
                }
                if (x < w - r) {
                    edges.add(new Edge(i, n + 1, w - x - r));
                } else {
                    union(i, n + 1);
                }

                for (int j = 0; j < i; j++) {
                    if (distance(points[i], points[j]) > points[i][2] + points[j][2]) {
                        edges.add(new Edge(i, j, distance(points[i], points[j]) - points[i][2] - points[j][2]));
                    } else {
                        union(i, j);
                    }
                }
            }

            Collections.sort(edges);

            double ans = 0;
            for (Edge edge : edges) {
                if (!union((int) edge.i, (int) edge.j)) {
                    continue;
                }
                if (find(n) == find(n + 1)) {
                    ans = edge.length / 2;
                    break;
                }
            }

            System.out.println(df.format(ans));
        }
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        parent[Math.min(x, y)] = Math.max(x, y);
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static double distance(int[] o1, int[] o2) {
        return Math.sqrt(square(o1[0] - o2[0]) + square(o1[1] - o2[1]));
    }

    private static long square(int x) {
        return (long) x * x;
    }
}

class Edge implements Comparable<Edge> {
    int i;
    int j;
    double length;

    public Edge(int i, int j, double length) {
        this.i = i;
        this.j = j;
        this.length = length;
    }

    public int compareTo(Edge other) {
        return Double.compare(this.length, other.length);
    }
}