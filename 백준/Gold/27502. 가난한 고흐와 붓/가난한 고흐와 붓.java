import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int count = N;

        if (t == 0) {
            System.out.println("! " + ((N + 1) / 2));
            System.out.flush();
        } else { // t == 1
            System.out.println("! " + (N / 2 + 1));
            System.out.flush();
            System.out.println("1 1");
            System.out.flush();
            count--;
        }

        for (int i = 0; i < N / 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            count--;
            if (count == 0) {
                return;
            }
            System.out.println(b + " " + a);
            System.out.flush();
        }
    }
}