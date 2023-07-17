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

        // 수의 변경이 일어나는 횟수 M
        int M = Integer.parseInt(st.nextToken());

        // 구간의 곱을 구하는 횟수 K
        M += Integer.parseInt(st.nextToken());

        // 수를 배열에 저장
        long[] a = new long[N];
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // 세그먼트 트리 만들기
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = 1 << (h+1);
        long[] tree = new long[tree_size];
        init(a, tree, 1, 0, N - 1);

        // 수의 변경과 구간 곱 출력 처리
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            // 수 변경
            if (st.nextToken().equals("1")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                update(a, tree, 1, 0, N - 1, index, val);
            }
            
            // 구간 곱 저장
            else {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(tree, 1, 0, N - 1, left, right)).append("\n");
            }
        }
        
        // 답 출력
        System.out.print(sb);
    }

    // 세그먼트 트리를 만드는 메서드
    private static void init(long[] a, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        }
        else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] * tree[node * 2 + 1] % 1_000_000_007;
        }
    }

    // 구간 곱 계산하기
    private static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 1;
        if (left <= start && end <= right) return tree[node];
        long leftProd = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rightProd = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return leftProd * rightProd % 1_000_000_007;
    }

    // 배열과 세그먼트 트리 갱신
    private static void update(long[] a, long[] tree, int node, int start, int end, int index, int val) {
        if (index < start || end < index) return;
        if (start == end) {
            a[index] = val;
            tree[node] = val;
            return;
        }
        update(a, tree, node * 2, start, (start + end) / 2, index, val);
        update(a, tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node * 2] * tree[node * 2 + 1] % 1_000_000_007;
    }
}
