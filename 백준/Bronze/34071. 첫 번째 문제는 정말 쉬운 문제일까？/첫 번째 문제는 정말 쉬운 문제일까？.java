import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int first = Integer.parseInt(br.readLine());
        int max, min;
        max = min = first;

        while (--N > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }

        System.out.println((first == min ? "ez" : first == max ? "hard" : '?'));
    }
}