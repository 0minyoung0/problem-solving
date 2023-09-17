import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x = x1 * y2 + x2 * y1;
        int y = y1 * y2;
        int gcd = GCD(Math.max(x, y), Math.min(x, y));
        System.out.print(x / gcd + " " + y / gcd);
    }

    private static int GCD(int x, int y) {
        if (x % y == 0) return y;
        return GCD(y, x % y);
    }
}

