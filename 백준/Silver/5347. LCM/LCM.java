import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
            BigInteger b = BigInteger.valueOf(Integer.parseInt(st.nextToken()));
            sb.append(a.multiply(b).divide(a.gcd(b))).append("\n");
        }
        System.out.print(sb);
    }
}