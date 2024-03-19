import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드의 개수
        int N = Integer.parseInt(br.readLine());

        // 트리 만들기
        List<Integer>[] edges = new List[N];
        for (int i=0; i<N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            edges[n1].add(n2);
            edges[n2].add(n1);
        }

        // 루트부터 탐색하면서 부모배열 첫 줄 채우고 각 노드 깊이 저장
        int[][] parent = new int[N][18];
        for (int i=0; i<N; i++) {
            Arrays.fill(parent[i], -1);
        }
        int[] depth = new int[N];
        Arrays.fill(depth, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        depth[0] = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int child : edges[cur]) {
                if (depth[child] != -1) continue;
                parent[child][0] = cur;
                queue.offer(child);
                depth[child] = depth[cur] + 1;
            }
        }

        // 부모배열 다 채우기
        for (int level=1; level<18; level++) {
            for (int node=1; node<N; node++) {
                if (parent[node][level - 1] != -1) {
                    parent[node][level] = parent[parent[node][level - 1]][level - 1];
                }
            }
        }

        // 공통 조상을 알고 싶은 쌍의 개수
        int M = Integer.parseInt(br.readLine());

        // 공통 조상 찾기
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            // 높이 맞추기
            if (depth[n1] < depth[n2]) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            int depthDiff = depth[n1] - depth[n2];
            for (int i=0; depthDiff != 0; i++) {
                if (depthDiff % 2 == 1) n1 = parent[n1][i];
                depthDiff /= 2;
            }

            // 이미 찾았으면 다음 루프
            if (n1 == n2) {
                sb.append(n1+1).append("\n");
                continue;
            }

            // 한번에 많이 건너뛸수 있는 경우부터 시작해서 공통 조상 찾기 전까지 올라가기
            for (int i=17; i>=0; i--) {
                // 배열 값이 없거나 (해당 높이의 조상이 없음)
                // 이미 공통 조상이어서 건너뛰었을 수 있는 경우는 무시
                if (parent[n1][i] == -1 || parent[n1][i] == parent[n2][i]) continue;
                // 그 외의 경우에는 위로 올라감
                n1 = parent[n1][i];
                n2 = parent[n2][i];
            }
            // 공통조상 저장
            sb.append(parent[n1][0]+1).append("\n");
        }

        // 답 출력
        System.out.print(sb);
    }
}