import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] H;
    static Set<Integer> ansSet;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        ansSet = new HashSet<>();

        bt(0, 0, 0);

        if (ansSet.isEmpty()) {
            System.out.println(-1);
            return;
        }

        List<Integer> ans = new ArrayList<>(ansSet);
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    private static void bt(int selectCount, int sum, int cur) {
        if (selectCount == M) {
            if (isPrime(sum)) {
                ansSet.add(sum);
            }
            return;
        }
        if (cur == N) {
            return;
        }

        // 선택한 경우
        bt(selectCount + 1, sum + H[cur], cur + 1);
        // 선택안한 경우
        bt(selectCount, sum, cur + 1);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}