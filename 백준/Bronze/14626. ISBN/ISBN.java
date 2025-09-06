import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int sum = 0;
        boolean isEven = false;
        for (int i = 0; i < 13; i++) {
            if (str.charAt(i) == '*') {
                if (i % 2 == 0) {
                    isEven = true;
                }
                continue;
            }
            sum += i % 2 == 0 ? (str.charAt(i) - '0') : (str.charAt(i) - '0') * 3;
        }
        for (int i = 0; i < 10; i++) {
            if ((sum + (isEven ? i : i * 3)) % 10 == 0) {
                System.out.println(i);
            }
        }
    }
}