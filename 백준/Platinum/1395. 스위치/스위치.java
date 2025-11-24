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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N];

        int treeSize = 1;
        while (treeSize < 2 * N) {
            treeSize *= 2;
        }
        tree = new long[treeSize];
        lazy = new long[treeSize];

        init(1, 0, N - 1);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int O = Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken()) - 1;
            right = Integer.parseInt(st.nextToken()) - 1;
            if (O == 0) {
                flipRange(1, 0, N - 1);
            } else { // O == 1
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
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    private static void updateLazy(int node, int start, int end) {
        if (lazy[node] == 0) {
            return;
        }
        tree[node] = (end - start + 1) - tree[node];
        if (start < end) {
            lazy[node * 2] = 1 - lazy[node * 2];
            lazy[node * 2 + 1] = 1 - lazy[node * 2 + 1];
        }
        lazy[node] = 0;
    }

    private static void flipRange(int node, int start, int end) {
        updateLazy(node, start, end);
        if (end < left || right < start) {
            return;
        }
        if (left <= start && end <= right) {
            tree[node] = (end - start + 1) - tree[node];
            if (start < end) {
                lazy[node * 2] = 1 - lazy[node * 2];
                lazy[node * 2 + 1] = 1 - lazy[node * 2 + 1];
            }
            return;
        }
        flipRange(node * 2, start, (start + end) / 2);
        flipRange(node * 2 + 1, (start + end) / 2 + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long getRange(int node, int start, int end) {
        updateLazy(node, start, end);
        if (end < left || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return getRange(node * 2, start, (start + end) / 2) + getRange(node * 2 + 1, (start + end) / 2 + 1, end);
    }
}
