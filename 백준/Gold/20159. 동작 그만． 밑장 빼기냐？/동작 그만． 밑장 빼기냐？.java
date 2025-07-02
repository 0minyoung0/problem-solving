import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            if (i % 2 == 1) {
                count += cards[i];
            }
        }
        int max = count;

        for (int i = 0; i < N - 1; i += 2) {
            count += cards[i] - cards[i + 1];
            if (max < count) {
                max = count;
            }
        }

        for (int i = N - 2; i >= 2; i -= 2) {
            count += cards[i - 1] - cards[i];
            if (max < count) {
                max = count;
            }
        }

        System.out.println(max);
    }
}