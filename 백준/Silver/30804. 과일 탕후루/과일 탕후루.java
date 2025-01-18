import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        char[] S = new char[N];
        for (int i = 0; i < N; i++) {
            S[i] = st.nextToken().charAt(0);
        }

        int start = 0;
        int end = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put(S[0], 1);

        int ans = 0;
        while (end < N) {
            // 두 종류 이내면 ans 갱신 및 end++
            if (map.size() <= 2) {
                if (ans < end - start + 1) {
                    ans = end - start + 1;
                }
                end++;
                if (end != N) {
                    map.put(S[end], map.getOrDefault(S[end], 0) + 1);
                }
            }

            // 두 종류 넘으면 start++
            else {
                if (map.get(S[start]) == 1) {
                    map.remove(S[start]);
                } else {
                    map.put(S[start], map.get(S[start]) - 1);
                }
                start++;
            }
        }
        System.out.println(ans);
    }
}
