import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX = 1003002;

    static boolean[] isNotPrime = new boolean[MAX];
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        init();
        findAns();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
    private static void findAns() {
        isNotPrime[1] = true;
        for (int i=2; i<MAX; i++) {
            if (isNotPrime[i]) continue;
            for (int j = 2 * i; j < MAX; j += i) {
                isNotPrime[j] = true;
            }
        }
        for (int i=N; i<MAX; i++) {
            if (isNotPrime[i]) continue;
            if (isPalindrome(i)) {
                ans = i;
                return;
            }
            for (int j = 2 * i; j < MAX; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
    private static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int idx1 = 0;
        int idx2 = s.length() - 1;
        while (idx1 < idx2) {
            if (s.charAt(idx1++) != s.charAt(idx2--)) return false;
        }
        return true;
    }
    private static void printAns() {
        System.out.print(ans);
    }
}