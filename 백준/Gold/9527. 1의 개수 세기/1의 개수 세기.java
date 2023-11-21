import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long A, B;

    public static void main(String[] args) throws IOException {
        init();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
    }
    private static void printAns() {
        System.out.print(solution(B) - solution(A - 1));
    }
    private static long solution(long x) {
        if (x <= 0) return 0;
        long temp = 0;
        while ((1L << (temp + 1)) - 1 <= x) {
            temp++;
        }
        return temp * (1L << (temp - 1)) + x - (1L << temp) + 1 + solution(x - (1L << temp));
    }
}