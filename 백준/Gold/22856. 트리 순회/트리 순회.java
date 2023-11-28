import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new int[N+1][2];
        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a][0] = b;
            tree[a][1] = c;
            if (b != -1) parent[b] = a;
            if (c != -1) parent[c] = a;
        }

        int end = 1;
        while (tree[end][1] != -1) {
            end = tree[end][1];
        }

        int ans = 0;
        int cur = 1;
        boolean[] vis = new boolean[N+1];
        vis[1] = true;
        while (true) {
            if (tree[cur][0] != -1 && !vis[tree[cur][0]]) {
                cur = tree[cur][0];
                vis[cur] = true;
                ans++;
            }
            else if (tree[cur][1] != -1 && !vis[tree[cur][1]]) {
                cur = tree[cur][1];
                vis[cur] = true;
                ans++;
            }
            else if (cur == end) {
                break;
            }
            else if (cur != 1) {
                cur = parent[cur];
                ans++;
            }
            else {
                break;
            }
        }
        System.out.print(ans);
    }
}