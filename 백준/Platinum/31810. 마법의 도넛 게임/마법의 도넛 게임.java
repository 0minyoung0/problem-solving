import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static int left, right;
    static int[] V;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            V = new int[N];
            for (int i = 0; i < N; i++) {
                V[i] = Integer.parseInt(st.nextToken());
            }

            int treeSize = 1;
            while (treeSize < 2 * N) {
                treeSize *= 2;
            }
            tree = new long[treeSize];
            lazy = new long[treeSize];

            init(1, 0, N - 1);

            st = new StringTokenizer(br.readLine());
            int[] S = new int[M];
            for (int i = 0; i < M; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] X = new int[M];
            for (int i = 0; i < M; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] Y = new int[M];
            for (int i = 0; i < M; i++) {
                Y[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            int dir = 1;

            for (int i = 0; i < M; i++) {
                int s = S[i];
                int x = X[i];
                int y = Y[i];

                if (s == 1) {
                    idx += (x * dir);
                    idx %= N;
                    idx += N;
                    idx %= N;
                } else if (s == 2) {
                    idx -= (x * dir);
                    idx %= N;
                    idx += N;
                    idx %= N;
                } else if (s == 3) {
                    dir *= -1;
                } else {
                    long ans = 0;

                    if (dir == 1) {
                        int sIdx = idx;
                        int eIdx = idx + x - 1;

                        if (eIdx < N) {
                            left = sIdx;
                            right = eIdx;
                            if (s == 4) {
                                updateRange(1, 0, N - 1, y);
                            } else {
                                ans += getRange(1, 0, N - 1);
                            }
                        } else {
                            left = sIdx;
                            right = N - 1;
                            if (s == 4) {
                                updateRange(1, 0, N - 1, y);
                            } else {
                                ans += getRange(1, 0, N - 1);
                            }
                            left = 0;
                            right = eIdx - N;
                            if (s == 4) {
                                updateRange(1, 0, N - 1, y);
                            } else {
                                ans += getRange(1, 0, N - 1);
                                ans %= MOD;
                            }
                        }
                    } else {
                        int eIdx = idx;
                        int sIdx = idx - x + 1;

                        if (sIdx >= 0) {
                            left = sIdx;
                            right = eIdx;
                            if (s == 4) {
                                updateRange(1, 0, N - 1, y);
                            } else {
                                ans += getRange(1, 0, N - 1);
                            }
                        } else {
                            left = 0;
                            right = eIdx;
                            if (s == 4) {
                                updateRange(1, 0, N - 1, y);
                            } else {
                                ans += getRange(1, 0, N - 1);
                            }
                            left = sIdx + N;
                            right = N - 1;
                            if (s == 4) {
                                updateRange(1, 0, N - 1, y);
                            } else {
                                ans += getRange(1, 0, N - 1);
                                ans %= MOD;
                            }
                        }
                    }

                    if (s == 5) {
                        sb.append(ans).append(' ');
                    }
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = V[start];
            return;
        }
        init(node * 2, start, (start + end) / 2);
        init(node * 2 + 1, (start + end) / 2 + 1, end);
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    private static void updateLazy(int node, int start, int end) {
        if (lazy[node] == 0) {
            return;
        }
        tree[node] += (end - start + 1) * lazy[node];
        tree[node] %= MOD;
        if (start < end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2] %= MOD;
            lazy[node * 2 + 1] += lazy[node];
            lazy[node * 2 + 1] %= MOD;
        }
        lazy[node] = 0;
    }

    private static void updateRange(int node, int start, int end, long val) {
        updateLazy(node, start, end);
        if (end < left || right < start) {
            return;
        }
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * val;
            tree[node] %= MOD;
            if (start < end) {
                lazy[node * 2] += val;
                lazy[node * 2] %= MOD;
                lazy[node * 2 + 1] += val;
                lazy[node * 2 + 1] %= MOD;
            }
            return;
        }
        updateRange(node * 2, start, (start + end) / 2, val);
        updateRange(node * 2 + 1, (start + end) / 2 + 1, end, val);
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    private static long getRange(int node, int start, int end) {
        updateLazy(node, start, end);
        if (end < left || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lSum = getRange(node * 2, start, (start + end) / 2);
        long rSum = getRange(node * 2 + 1, (start + end) / 2 + 1, end);
        return (lSum + rSum) % MOD;
    }
}
