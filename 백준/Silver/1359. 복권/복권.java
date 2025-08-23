import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = K; i <= M; i++) {
            sum += combi(M, i) * combi(N - M, M - i);
        }
        System.out.println(((double) sum) / combi(N, M));
    }

    private static int combi(int n, int r) {
        if (n < r) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i <= r; i++) {
            result *= (n - i + 1);
            result /= i;
        }
        return result;
    }
}