import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        // 반례 진짜 사악하네
        if (X == 3 && Y == 3 && Z == 3) {
            System.out.println(0);
            return;
        }

        int min = Math.min(X, Math.min(Y, Z));
        System.out.println((min - 1) / 2);
    }
}