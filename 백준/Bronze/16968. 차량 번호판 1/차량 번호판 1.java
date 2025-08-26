import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int ans = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            int x = c == 'c' ? 26 : 10;
            if (i > 0 && str.charAt(i - 1) == c) {
                x--;
            }

            ans *= x;
        }
        System.out.println(ans);
    }
}