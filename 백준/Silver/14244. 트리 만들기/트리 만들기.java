import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n - m; i++) {
            sb.append(i - 1).append(' ').append(i).append('\n');
        }
        for (int i = n - m + 1; i < n; i++) {
            sb.append(n - m).append(' ').append(i).append('\n');
        }
        System.out.print(sb);
    }
}
