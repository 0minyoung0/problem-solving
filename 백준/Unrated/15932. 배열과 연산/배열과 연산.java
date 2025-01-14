import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] operators = new String[q];
        int[] Y = new int[m];

        for (int i = 0; i < q; i++) {
            operators[i] = br.readLine();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            Y[i] = Integer.parseInt(st.nextToken());
        }

        // 역순으로 계산
        int[] idx = Arrays.copyOf(Y, m);
        int[] ans = new int[m];
        for (int line = q - 1; line >= 0; line--) {
            String operator = operators[line];
            st = new StringTokenizer(operator);
            if (st.nextToken().charAt(0) == 'r') {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                for (int cur = 0; cur < m; cur++) {
                    if (idx[cur] >= i && idx[cur] <= j) {
                        idx[cur] = i + j - idx[cur];
                    }
                }
            } else {
                for (int cur = 0; cur < m; cur++) {
                    ans[cur] += idx[cur];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb);
    }
}
