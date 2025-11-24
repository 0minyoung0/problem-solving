import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    static long[] tree;
    static long[] lazy;
    static int left, right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int treeSize = 1;
        while (treeSize < 2 * N) {
            treeSize *= 2;
        }
        tree = new long[treeSize];
        lazy = new long[treeSize];

        init(1, 0, N - 1);

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int k = Integer.parseInt(st.nextToken());
                xorRange(1, 0, N - 1, k);
            } else { // q == 2
                sb.append(getRange(1, 0, N - 1)).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = A[start];
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
        }
    }

    private static void updateLazy(int node, int start, int end) {
        if (lazy[node] == 0) {
            return;
        }
        if ((end - start + 1) % 2 == 1) {
            tree[node] ^= lazy[node];
        }
        if (start < end) {
            lazy[node * 2] ^= lazy[node];
            lazy[node * 2 + 1] ^= lazy[node];
        }
        lazy[node] = 0;
    }

    private static void xorRange(int node, int start, int end, int val) {
        updateLazy(node, start, end);
        if (end < left || right < start) {
            return;
        }
        if (left <= start && end <= right) {
            if ((end - start + 1) % 2 == 1) {
                tree[node] ^= val;
            }
            if (start < end) {
                lazy[node * 2] ^= val;
                lazy[node * 2 + 1] ^= val;
            }
            return;
        }
        xorRange(node * 2, start, (start + end) / 2, val);
        xorRange(node * 2 + 1, (start + end) / 2 + 1, end, val);
        tree[node] = tree[node * 2] ^ tree[node * 2 + 1];
    }

    private static long getRange(int node, int start, int end) {
        updateLazy(node, start, end);
        if (end < left || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return getRange(node * 2, start, (start + end) / 2) ^ getRange(node * 2 + 1, (start + end) / 2 + 1, end);
    }
}
