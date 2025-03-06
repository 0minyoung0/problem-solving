import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int B = Integer.parseInt(st.nextToken());
            int start = -1;
            int end = N - 1;

            while (start < end) {
                int mid = (start + end + 1) / 2;
                if (A.get(mid) <= B) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }

            int count = start + 1;
            int k = 0;
            while (3 * (k + 1) * k + 1 <= count) {
                k++;
            }

            sb.append(k).append(' ');
        }

        System.out.print(sb);
    }
}