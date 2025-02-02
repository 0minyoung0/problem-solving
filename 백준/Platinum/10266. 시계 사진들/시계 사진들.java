import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] degrees = new int[2][n];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                degrees[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.parallelSort(degrees[i]);
        }

        int[] diff0 = new int[2 * n];
        for (int j = 0; j < n - 1; j++) {
            diff0[j + n] = diff0[j] = degrees[0][j + 1] - degrees[0][j];
        }
        diff0[2 * n - 1] = diff0[n - 1] = degrees[0][0] - degrees[0][n - 1] + 360000;

        int[] diff1 = new int[n];
        for (int j = 0; j < n - 1; j++) {
            diff1[j] = degrees[1][j + 1] - degrees[1][j];
        }
        diff1[n - 1] = degrees[1][0] - degrees[1][n - 1] + 360000;

        int[] f = failure(diff1);

        int j = 0;
        for (int i = 0; i < diff0.length; i++) {
            while (j > 0 && diff0[i] != diff1[j]) j = f[j - 1];
            if (diff0[i] == diff1[j]) j++;
            if (j == diff1.length) {
                System.out.println("possible");
                return;
            } 
        }
        System.out.println("impossible");
    }
    private static int[] failure (int[] s) {
        int[] f = new int[s.length];
        int j = 0;
        for (int i = 1; i < s.length; i++) {
            while (j > 0 && s[i] != s[j]) j = f[j - 1];
            if (s[i] == s[j]) f[i] = ++j;
        }
        return f;
    }
}
