import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;

        // 간선 정보
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i=0; i<N; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            edges.get(A).add(B);
        }
        int[] dis = new int[N];
        Arrays.fill(dis, N);
        dis[X] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(X);

        List<Integer> answers = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nx : edges.get(cur)) {
                if (dis[nx] < N) continue;
                dis[nx] = dis[cur] + 1;
                if (dis[nx] == K) {
                    answers.add(nx);
                    continue;
                }
                queue.offer(nx);
            }
        }

        // 답 출력
        StringBuilder sb = new StringBuilder();
        if (answers.isEmpty()) sb.append(-1);
        else {
            Collections.sort(answers);
            for (int ans : answers) {
                sb.append(ans + 1).append('\n');
            }
        }
        System.out.print(sb);
    }
}