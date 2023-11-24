import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isNotPrime = new boolean[10000];
    static List<Integer>[] graph = new List[10000];

    static int T;
    static int[][] input;

    public static void main(String[] args) throws IOException {
        init();
        getInput();
        printAns();
    }
    private static void init() {
        for (int i=2; i<10000; i++) {
            if (isNotPrime[i]) continue;
            for (int j=2*i; j<10000; j+=i) {
                isNotPrime[j] = true;
            }
        }
        for (int i=1000; i<10000; i++) {
            if (isNotPrime[i]) continue;
            graph[i] = new ArrayList<>();
        }
        for (int i=1000; i<10000; i++) {
            if (isNotPrime[i]) continue;
            for (int j=1; j<10-i/1000; j++) {
                if (isNotPrime[i+j*1000]) continue;
                graph[i].add(i+j*1000);
                graph[i+j*1000].add(i);
            }
            for (int j=1; j<10-i%1000/100; j++) {
                if (isNotPrime[i+j*100]) continue;
                graph[i].add(i+j*100);
                graph[i+j*100].add(i);
            }
            for (int j=1; j<10-i%100/10; j++) {
                if (isNotPrime[i+j*10]) continue;
                graph[i].add(i+j*10);
                graph[i+j*10].add(i);
            }
            for (int j=1; j<10-i%10; j++) {
                if (isNotPrime[i+j]) continue;
                graph[i].add(i+j);
                graph[i+j].add(i);
            }
        }
    }
    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        input = new int[T][2];
        for (int[] line : input) {
            st = new StringTokenizer(br.readLine());
            line[0] = Integer.parseInt(st.nextToken());
            line[1] = Integer.parseInt(st.nextToken());
        }
    }
    private static void printAns() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            if (input[i][0] == input[i][1]) sb.append("0\n");
            else sb.append(simulation(input[i][0], input[i][1])).append("\n");
        }
        System.out.print(sb);
    }
    private static String simulation(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[10000];
        q.offer(x);
        vis[x] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int cur = q.poll();
                for (int nx : graph[cur]) {
                    if (vis[nx]) continue;
                    if (nx == y) return Integer.toString(cnt);
                    q.offer(nx);
                    vis[nx] = true;
                }
            }
            cnt++;
        }
        return "Impossible";
    }
}