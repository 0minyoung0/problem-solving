import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            boolean isBlack1 = (s1.charAt(0) - 'A' + s1.charAt(1) - '1') % 2 == 1;
            boolean isBlack2 = ((Integer.parseInt(s2) - 1) % 8 + (Integer.parseInt(s2) - 1) / 8) % 2 == 1;
            System.out.println(isBlack1 == isBlack2 ? "YES" : "NO");
        }
    }
}