import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 444_449;
    static int[] L, R;
    static List<Integer> nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] A = new int[N + 2];
            A[0] = 0;
            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            A[N + 1] = V + 1;

            int[] P = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            L = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                L[i] = Integer.parseInt(st.nextToken());
                if (L[i] != 0) {
                    P[L[i]] = i;
                }
            }

            st = new StringTokenizer(br.readLine());
            R = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                R[i] = Integer.parseInt(st.nextToken());
                if (R[i] != 0) {
                    P[R[i]] = i;
                }
            }

            int root = -1;
            for (int i = 1; i <= N; i++) {
                if (P[i] == 0) {
                    root = i;
                }
            }

            nodes = new ArrayList<>();
            inorderTraverse(root);
            nodes.add(N + 1);

            long ans = 1;
            int prevNode = 0;
            int count = 0;
            for (int node : nodes) {
                if (A[node] == 0) {
                    count++;
                } else {
                    ans = multiple(ans, combination(A[node] - A[prevNode] - 1, count));
                    prevNode = node;
                    count = 0;
                }
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static long combination(int n, int r) {
        if (n < r) {
            return 0;
        }
        r = Math.min(r, n - r);
        long x = 1;
        long y = 1;
        for (int i = 0; i < r; i++) {
            x *= (n - i);
            x %= MOD;
            y *= (i + 1);
            y %= MOD;
        }
        return multiple(x, pow(y, MOD - 2));
    }

    private static long pow(long a, int x) {
        if (x == 0) {
            return 1;
        }
        long sqrt = pow(a, x / 2);
        long ans = multiple(sqrt, sqrt);
        if (x % 2 == 0) {
            return ans;
        }
        return multiple(ans, a);
    }

    private static long multiple(long x, long y) {
        return x * y % MOD;
    }

    private static void inorderTraverse(int node) {
        if (L[node] != 0) {
            inorderTraverse(L[node]);
        }
        nodes.add(node);
        if (R[node] != 0) {
            inorderTraverse(R[node]);
        }
    }
}
