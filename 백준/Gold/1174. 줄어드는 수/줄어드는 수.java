import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 줄어드는 수의 개수는 2^10 - 1개
        if (N > (1 << 10) - 1) {
            System.out.println(-1);
            return;
        }

        list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            bt(i);
        }
        Collections.sort(list);

        System.out.println(list.get(N - 1));
    }

    private static void bt(long prev) {
        list.add(prev);
        for (int nx = 0; nx < prev % 10; nx++) {
            bt(10 * prev + nx);
        }
    }
}