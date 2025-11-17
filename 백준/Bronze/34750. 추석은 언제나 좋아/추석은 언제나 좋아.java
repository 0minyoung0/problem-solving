import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int X = 0;

        if (N >= 1_000_000) {
            X = N / 100 * 20;
        } else if (N >= 500_000) {
            X = N / 100 * 15;
        } else if (N >= 100_000) {
            X = N / 100 * 10;
        } else {
            X = N / 100 * 5;
        }
        System.out.println(X + " " + (N - X));
    }
}
