import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(2 * N - 1);

        for (int i = 1; i < N; i++) {
            int s = 1 + (N + 1) * (i - 1);
            int e = s + N - 1;
            sb.append('\n').append(s).append(' ').append(e).append(' ').append(i).append(' ').append(1);
        }
        sb.append('\n').append(N * N).append(' ').append(N * N).append(' ').append(N).append(" 1");
        for (int i = 2; i <= N; i++) {
            int num = (i - 1) * (N + 1);
            sb.append('\n').append(num).append(' ').append(num).append(' ').append(N).append(' ').append(i);
        }

        System.out.println(sb);
    }
}
