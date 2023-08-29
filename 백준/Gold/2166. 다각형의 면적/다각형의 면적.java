import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] x = new long[N];
        long[] y = new long[N];
        st = new StringTokenizer(br.readLine());
        x[0] = Long.parseLong(st.nextToken());
        y[0] = Long.parseLong(st.nextToken());
        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken()) - x[0];
            y[i] = Long.parseLong(st.nextToken()) - y[0];
        }

        long ans = 0;
        for (int i=1; i<N-1; i++) {
            ans += x[i] * y[i+1] - y[i] * x[i+1];
        }
        System.out.print(Math.abs(ans/2));
        if (ans % 2 == 1) System.out.print(".5");
        else System.out.print(".0");
    }
}
