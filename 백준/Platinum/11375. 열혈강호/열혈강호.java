import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] works;
    static int run;
    static int[] assign;
    static int[] done;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        works = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            works[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int jobsNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < jobsNum; j++) {
                works[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        assign = new int[M + 1];
        done = new int[M + 1];

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            run = i;
            if (dfs(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int x) {
        for (int work : works[x]) {
            if (done[work] == run) {
                continue;
            }
            done[work] = run;
            if (assign[work] == 0 || dfs(assign[work])) {
                assign[work] = x;
                return true;
            }
        }
        return false;
    }
}
