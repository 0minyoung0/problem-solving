import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int ans0 = 1;
        int ans1 = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String option1 = st.nextToken();
            String option2 = st.nextToken();

            ans1 = Math.max(ans0, operateOptions(ans1, option1, option2));
            ans0 = operateOptions(ans0, option1, option2);

            if (ans0 == 0 && ans1 == 0) {
                System.out.println("ddong game");
                return;
            }
        }
        System.out.println(Math.max(ans0, ans1));
    }

    private static int operateOptions(int prev, String option1, String option2) {
        return Math.max(Math.max(operate(prev, option1), operate(prev, option2)), 0);
    }

    private static int operate(int prev, String option) {
        if (prev == 0) {
            return 0;
        }

        char op = option.charAt(0);
        int num = option.charAt(1) - '0';

        switch (op) {
            case '+':
                return prev + num;
            case '-':
                return prev - num;
            case '*':
                return prev * num;
            case '/':
                return prev / num;
            default:
                return prev;
        }
    }
}