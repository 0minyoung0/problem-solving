import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] roulette = new char[N];
        for (int i=0; i<N; i++) {
            roulette[i] = st.nextToken().charAt(0);
        }
        int prefixCnt = roulette.length - failure(roulette)[roulette.length - 1];
        int x = 1;
        if (roulette.length % prefixCnt == 0) x = roulette.length / prefixCnt;
        int GCD = gcd(N, x);
        System.out.println((x / GCD) + "/" + (N / GCD));
    }
    private static int[] failure(char[] s) {
        int[] f = new int[s.length];
        int j = 0;
        for (int i=1; i<s.length; i++) {
            while (j > 0 && s[i] != s[j]) j = f[j-1];
            if (s[i] == s[j]) f[i] = ++j;
        }
        return f;
    }
    private static int gcd (int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}