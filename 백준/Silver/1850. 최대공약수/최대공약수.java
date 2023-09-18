import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long gcd = GCD(Math.max(x, y), Math.min(x, y));
        StringBuilder sb = new StringBuilder();
        while (gcd-- > 0) {
            sb.append(1);
        }
        System.out.print(sb);
    }

    private static long GCD(long x, long y) {
        if (x % y == 0) {
            return y;
        }
        return GCD(y, x % y);
    }
}

