import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 지금 이해한게 맞으면 이렇게 풀리는건데 실화임?
        String a = br.readLine();
        int countA = 0;
        for (char c : a.toCharArray()) {
            if (c == '1') {
                countA++;
            }
        }
        String b = br.readLine();
        int countB = 0;
        for (char c : b.toCharArray()) {
            if (c == '1') {
                countB++;
            }
        }

        boolean isVictory = (countA + 1) / 2 >= (countB + 1) / 2;
        System.out.println(isVictory ? "VICTORY" : "DEFEAT");
    }
}
