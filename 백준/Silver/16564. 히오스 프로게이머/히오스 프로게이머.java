import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(br.readLine());
        }
        Arrays.parallelSort(X);

        int s = 1;
        int e = 2_000_000_000;

        while (s < e) {
            int mid = (int) (((long) s + e + 1) / 2);

            long needLevel = 0;
            for (int x : X) {
                if (x >= mid) {
                    break;
                }
                needLevel += (mid - x);
            }

            if (needLevel > K) {
                e = mid - 1;
            } else { // needLevel <= K
                s = mid;
            }
        }
        System.out.println(s);
    }
}