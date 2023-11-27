import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N == 0) {
            System.out.print(0);
            return;
        }
        Deque<Boolean> isOne = new ArrayDeque<>();
        int cur = 1;
        while (N != 0) {
            if (N % 2 != 0) {
                N -= cur;
                isOne.offerFirst(true);
            }
            else {
                isOne.offerFirst(false);
            }
            N >>= 1;
            cur *= -1;
        }
        StringBuilder sb = new StringBuilder();
        while (!isOne.isEmpty()) {
            sb.append(isOne.poll() ? 1 : 0);
        }
        System.out.print(sb);
    }
}