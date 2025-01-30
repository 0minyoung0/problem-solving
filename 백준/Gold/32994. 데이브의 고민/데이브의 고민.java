import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        // 행 번호 변할때 두 칸씩 땡기면 됨
        for (int i=0; i<N; i++) {
            if (i != 0) sb.append('\n');
            for (int j=0; j<M; j++) {
                if (j != 0) sb.append(' ');
                sb.append((2 * i + j) % 5 + 1);
            }
        }
        System.out.println(sb);
    }
}
