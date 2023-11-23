import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static long A, B, C, D;
    static long ans = 1_000_000_000_000_000_001L;

    public static void main(String[] args) throws IOException {
        init();
        calculate();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        D = Long.parseLong(st.nextToken());
        if (B * C > D * A) swap();
    }
    private static void swap() {
        long temp = A;
        A = C;
        C = temp;
        temp = B;
        B = D;
        D = temp;
    }
    private static void calculate() {
        for (int i=0; i<A; i++) {
            long temp = D * i;
            if (N > C * i) {
                temp += ((N - C * i) / A + ((N - C * i) % A == 0 ? 0 : 1)) * B;
            }
            if (ans > temp) ans = temp;
        }
    }
    private static void printAns() {
        System.out.print(ans);
    }
}