import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 수
        int N = Integer.parseInt(br.readLine());
        // 여행 계획에 속한 도시들의 수
        int M = Integer.parseInt(br.readLine());
        if (M == 1) {
            System.out.println("YES");
            return;
        }

        // parent 배열
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 도시 연결 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) union(i + 1, j + 1);
            }
        }

        // 여행 계획 가능한지 확인
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            if (union(start, Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        parent[Math.max(x, y)] = Math.min(x, y);
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}