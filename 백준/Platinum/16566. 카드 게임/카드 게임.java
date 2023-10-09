import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 2];
        for (int i = 1; i <= N + 1; i++) {
            parent[i] = i;
        }

        // 민수의 카드를 리스트에 저장
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.add(N + 1);
        Collections.sort(list);

        // 철수가 낼 카드에 따라 민수가 낼 카드 출력
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            int c = Integer.parseInt(st.nextToken());

            int idx1 = Collections.binarySearch(list, c + 1);
            if (idx1 < 0) idx1 = -idx1 - 1;
            int m1 = parent[list.get(idx1)];
            while (parent[m1] != m1) {
                m1 = parent[m1];
            }

            int idx2 = Collections.binarySearch(list, m1 + 1);
            if (idx2 < 0) idx2 = -idx2 - 1;
            int m2 = parent[list.get(idx2)];
            while (parent[m2] != m2) {
                m2 = parent[m2];
            }

            union(m1, m2);
            sb.append(m1).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        parent[Math.min(x, y)] = Math.max(x, y);
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
