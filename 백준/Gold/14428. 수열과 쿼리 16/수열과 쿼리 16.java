import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 수열의 크기 n
        int n = Integer.parseInt(br.readLine());

        // 배열 a에 n개의 수 저장
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 쿼리의 개수 m
        int m = Integer.parseInt(br.readLine());

        // 세그먼트 트리 만들기
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int tree_size = 1 << (h + 1);
        int[] tree = new int[tree_size];
        init(a, tree, 1, 0, n - 1);

        // m개의 쿼리 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                update(a, tree, 1, 0, n - 1, index, val);
            } else {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(a, tree, 1, 0, n - 1, left, right) + 1).append("\n");
            }
        }

        // 답 출력
        System.out.print(sb);
    }

    // 작은 노드 찾기
    private static int comp(int[] a, int[] tree, int leftNode, int rightNode) {
        if (a[tree[leftNode]] < a[tree[rightNode]]) {
            return tree[leftNode];
        }
        if (a[tree[leftNode]] > a[tree[rightNode]]) {
            return tree[rightNode];
        }
        return Math.min(tree[leftNode], tree[rightNode]);
    }

    // 세그먼트 트리 만들기
    private static void init(int[] a, int[] tree, int node, int start, int end) {

        if (start == end) {
            tree[node] = start;
        } else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);

            tree[node] = comp(a, tree, node * 2, node * 2 + 1);
        }
    }

    // 값 변경하고 세그 트리에 반영
    private static void update(int[] a, int[] tree, int node, int start, int end, int index,
            int val) {
        if (index < start || end < index) {
            return;
        }

        if (start == end) {
            a[index] = val;
            return;
        }

        update(a, tree, node * 2, start, (start + end) / 2, index, val);
        update(a, tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);

        tree[node] = comp(a, tree, node * 2, node * 2 + 1);
    }

    // 세그먼트 트리에서 연산값 구하기
    private static int query(int[] a, int[] tree, int node, int start, int end, int left,
            int right) {
        if (end < left || right < start) {
            return -1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int leftIdx = query(a, tree, node * 2, start, (start + end) / 2, left, right);
        int rightIdx = query(a, tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);

        if (leftIdx == -1) return rightIdx;
        if (rightIdx == -1) return leftIdx;
        if (a[leftIdx] < a[rightIdx]) return leftIdx;
        if (a[rightIdx] < a[leftIdx]) return rightIdx;
        return Math.min(leftIdx, rightIdx);
    }
}
