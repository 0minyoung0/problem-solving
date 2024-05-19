import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 0; tc <= 10; tc++) {
            String s = br.readLine();
            if (s.equals(".")) return;
            int prefixCnt = s.length() - failure(s.toCharArray())[s.length() - 1];
            if (s.length() % prefixCnt != 0) System.out.println(1);
            else System.out.println(s.length() / prefixCnt);
        }
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