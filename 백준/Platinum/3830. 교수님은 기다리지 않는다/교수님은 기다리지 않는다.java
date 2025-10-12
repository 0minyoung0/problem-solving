import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] weight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            parent = new int[N + 1];
            weight = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (oper == '!') {
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else { // oper == '?'
                    if (find(a) != find(b)) {
                        sb.append("UNKNOWN\n");
                    } else {
                        sb.append(weight[b] - weight[a]).append('\n');
                    }
                }
            }
        }
        System.out.print(sb);
    }

    private static boolean union(int a, int b, int w) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return false;
        }

        weight[y] = weight[a] - weight[b] + w;
        parent[y] = x;
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        int root = find(parent[x]);
        weight[x] += weight[parent[x]];
        return parent[x] = root;
    }
}
