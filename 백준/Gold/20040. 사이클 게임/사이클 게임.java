import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] parent;
    static int[][] line;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i=1; i<n; i++) {
            parent[i] = i;
        }
        line = new int[m][2];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    private static void simulation() {
        for (int i=0; i<m; i++) {
            if (!union(line[i][0], line[i][1])) {
                System.out.print(i + 1);
                return;
            }
        }
        System.out.print(0);
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
