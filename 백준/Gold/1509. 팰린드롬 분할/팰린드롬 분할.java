import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        int N = string.length;
        
        // i번째 문자부터 j번째 문자까지 연속해서 이루는 문자열이 팰린드롬인지 확인
        boolean[][] isPalindrome = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            isPalindrome[i][i] = true;
        }
        for (int l = 1; l < N; l++) {
            for (int i = 0; i + l < N; i++) {
                if (string[i] == string[i + l] && (l == 1 || isPalindrome[i + 1][i + l - 1])) {
                    isPalindrome[i][i + l] = true;
                }
            }
        }

        // dp로 답 계산
        int[] ans = new int[N];
        for (int i=0; i<N; i++) {
            if (isPalindrome[0][i]) {
                ans[i] = 1;
            }
            else {
                ans[i] = ans[i - 1] + 1;
                for (int j = i - 1; j >= 1; j--) {
                    if (isPalindrome[j][i] && ans[i] > ans[j - 1] + 1) {
                        ans[i] = ans[j - 1] + 1;
                    }
                }
            }
        }
        System.out.print(ans[N-1]);
    }
}

