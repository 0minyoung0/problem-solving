import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (tree[i].size() == 1) {
                queue.offer(i);
                isVisit[i] = true;
            } else if (tree[i].size() != 3) {
                System.out.println(-1);
                return;
            }
        }

        while (!queue.isEmpty()) {
            // 루트 노드 찾았는지 확인
            if (queue.size() == 1) {
                int root = queue.poll();
                boolean isAnswer = true;
                for (int n : tree[root]) {
                    if (!isVisit[n]) {
                        isAnswer = false;
                        break;
                    }
                }
                if (isAnswer) {
                    System.out.println("1\n" + root);
                    return;
                }
            }

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int cur = queue.poll();
                for (int nx : tree[cur]) {
                    if (isVisit[nx]) {
                        continue;
                    }
                    queue.offer(nx);
                    isVisit[nx] = true;
                }
            }
        }

        System.out.println(-1);

    }
}