import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;
    static Map<Integer, Integer> leftMap = new HashMap<>();
    static Map<Integer, Integer> rightMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        fillLeftMap(0, 0);
        fillRightMap(N/2, 0);

        long ans = 0;
        for (int key : leftMap.keySet()) {
            if (rightMap.containsKey(S - key)) {
                ans += (long)leftMap.get(key) * (long)rightMap.get(S - key);
            }
        }
        if (leftMap.containsKey(S)) {
            ans += leftMap.get(S);
        }
        if (rightMap.containsKey(S)) {
            ans += rightMap.get(S);
        }
        System.out.println(ans);
    }
    private static void fillLeftMap(int idx, int curSum) {
        if (idx >= N / 2) {
            return;
        }
        if (!leftMap.containsKey(curSum + nums[idx])) {
            leftMap.put(curSum + nums[idx], 1);
        }else {
            leftMap.put(curSum + nums[idx], leftMap.get(curSum + nums[idx]) + 1);
        }
        fillLeftMap(idx + 1, curSum);
        fillLeftMap(idx + 1, curSum + nums[idx]);
    }
    private static void fillRightMap(int idx, int curSum) {
        if (idx >= N) {
            return;
        }
        if (!rightMap.containsKey(curSum + nums[idx])) {
            rightMap.put(curSum + nums[idx], 1);
        }else {
            rightMap.put(curSum + nums[idx], rightMap.get(curSum + nums[idx]) + 1);
        }
        fillRightMap(idx + 1, curSum);
        fillRightMap(idx + 1, curSum + nums[idx]);
    }
}
