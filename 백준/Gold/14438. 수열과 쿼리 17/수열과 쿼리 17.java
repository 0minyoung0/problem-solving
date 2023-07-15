import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 수의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 배열에 N개의 수 저장
        long[] a = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        // 쿼리의 개수
        int M = Integer.parseInt(br.readLine());

        // 세그먼트 트리 만들기
        int h = (int)Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = 1 << (h + 1);
        long[] tree = new long[tree_size];
        init(a, tree, 1, 0, N - 1);

        // M개의 쿼리 처리
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            // 수 변경
            if (st.nextToken().equals("1")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                long val = Long.parseLong(st.nextToken());
                update(a, tree, 1, 0, N-1, index, val);
            }

            // 구간 최소 값 출력
            else {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(tree, 1, 0, N - 1, left, right)).append("\n");
            }
        }

        // 답 출력
        System.out.print(sb);
    }
    public static void init(long[] a, long[] tree, int node, int start, int end) {
        if (start == end) tree[node] = a[start];
        else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }
    public static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        long lmin = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rmin = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lmin == 0 ? rmin : rmin == 0 ? lmin : Math.min(lmin, rmin);
    }
    public static void update(long[] a, long[] tree, int node, int start, int end, int index, long val) {
        if (index < start || end < index) return;
        if (start == end) {
            a[index] = val;
            tree[node] = val;
            return;
        }
        update(a, tree, node * 2, start, (start + end) / 2, index, val);
        update(a, tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }
}
