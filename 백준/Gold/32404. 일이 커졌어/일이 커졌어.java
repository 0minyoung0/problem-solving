import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int mid = N / 2;

        for (int i = 0; i < mid; i++) {
            sb.append(mid + i + 1).append(' ').append(mid - i).append(' ');
        }

        if (N % 2 == 1) {
            sb.append(N);
        }
        System.out.println(sb);
    }
}