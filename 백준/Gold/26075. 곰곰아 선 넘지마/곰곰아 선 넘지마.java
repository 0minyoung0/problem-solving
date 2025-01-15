import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st.nextToken();

        char[] S = br.readLine().toCharArray();
        char[] T = br.readLine().toCharArray();

        int sIdx = 0;
        int tIdx = 0;
        long count = 0;
        while (N-- > 0) {
            while (S[sIdx] != '0') {
                sIdx++;
            }
            while (T[tIdx] != '0') {
                tIdx++;
            }

            count += Math.abs(sIdx++ - tIdx++);
        }
        System.out.println((count / 2) * (count / 2) + ((count + 1) / 2) * ((count + 1) / 2));
    }
}
