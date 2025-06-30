import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int L = Integer.parseInt(br.readLine());

        int remainExp = (250 - L) * 100;

        if (remainExp <= C * 30 * V) {
            System.out.println((int) Math.ceil((double) remainExp / C));
            return;
        }
        remainExp -= C * 30 * V;
        if (remainExp <= B * 30 * S) {
            System.out.println(30 * V + (int) Math.ceil((double) remainExp / B));
            return;
        }
        remainExp -= B * 30 * S;
        System.out.println(30 * V + 30 * S + (int) Math.ceil((double) remainExp / A));
    }
}