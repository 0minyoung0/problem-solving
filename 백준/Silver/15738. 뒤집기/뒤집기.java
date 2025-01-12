import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        br.readLine();
        while (M-- > 0) {
            int i = Integer.parseInt(br.readLine());
            int start = i > 0 ? 1 : N + i + 1;
            int end = i > 0 ? i : N;
            if (start <= K && K <= end) {
                K = start + end - K;
            }
        }
        System.out.println(K);
    }
}
