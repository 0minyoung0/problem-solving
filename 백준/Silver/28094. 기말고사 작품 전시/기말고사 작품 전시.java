import java.io.*;
import java.util.*;

public class Main {
    static int maxScore, ansCount, N;
    static int[][] value;
    static int[] nums;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            value = new int[N][N];

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken()) - 1;
                int B = Integer.parseInt(st.nextToken()) - 1;

                value[A][B] += V;
            }

            maxScore = ansCount = 0;
            nums = new int[N];
            visit = new boolean[N];
            bt(0);
            sb.append(maxScore).append(' ').append(ansCount).append('\n');
        }
        System.out.print(sb);
    }

    private static void bt(int depth) {
        if (depth == N) {
            int score = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    score += value[nums[i]][nums[j]];
                }
            }

            if (maxScore < score) {
                maxScore = score;
                ansCount = 0;
            }
            if (maxScore == score) {
                ansCount++;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            nums[depth] = i;
            bt(depth + 1);
            visit[i] = false;
        }
    }
}
