import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 수의 개수 N
        int N = Integer.parseInt(st.nextToken());

        // 쿼리의 개수 M
        int M = Integer.parseInt(st.nextToken());

        // 배열에 N개의 수 저장
        int[] a = new int[N];
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // 세그먼트 트리 만들기
        int h = (int)Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = 1 << (h + 1);
        int[][] tree = new int[2][tree_size];
        init(a, tree, 1, 0, N - 1);

        // M개의 쿼리 처리
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            sb.append(minQuery(tree[0], 1, 0, N - 1, left, right)).append(" ");
            sb.append(maxQuery(tree[1], 1, 0, N - 1, left, right)).append("\n");
        }

        // 답 출력
        System.out.print(sb);
    }

    // 구간 최솟값, 최댓값 세그먼트 트리 만들기
    public static void init(int[] a, int[][] tree, int node, int start, int end) {
        if (start == end) {
            tree[0][node] = a[start];
            tree[1][node] = a[start];
        }
        else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[0][node] = Math.min(tree[0][node * 2], tree[0][node * 2 + 1]);
            tree[1][node] = Math.max(tree[1][node * 2], tree[1][node * 2 + 1]);
        }
    }

    // 세그먼트 트리에서 구간 최솟값 구하기
    public static int minQuery(int[] minTree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) return 1000000001;
        if (left <= start && end <= right) return minTree[node];
        int lmin = minQuery(minTree, node * 2, start, (start + end) / 2, left, right);
        int rmin = minQuery(minTree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.min(lmin, rmin);
    }
    
    // 세그먼트 트리에서 구간 최댓값 구하기
    public static int maxQuery(int[] maxTree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) return 0;
        if (left <= start && end <= right) return maxTree[node];
        int lmax = maxQuery(maxTree, node * 2, start, (start + end) / 2, left, right);
        int rmax = maxQuery(maxTree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.max(lmax, rmax);
    }
}
