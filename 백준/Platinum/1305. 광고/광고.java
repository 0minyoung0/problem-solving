import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] ad = br.readLine().toCharArray();
        int[] f = failure(ad);
        System.out.println(L - f[ad.length - 1]);
    }
    private static int[] failure(char[] s) {
        int[] f = new int[s.length];
        int j = 0;
        for (int i=1; i<s.length; i++) {
            while (j > 0 && s[i] != s[j]) j = f[j-1];
            if (s[i] == s[j]) f[i] = ++j;
        }
        return f;
    }
}