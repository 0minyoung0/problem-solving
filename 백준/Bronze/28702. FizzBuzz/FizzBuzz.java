import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[3];
        for (int i = 0; i < 3; i++) {
            inputs[i] = br.readLine();
        }

        int num;
        if (inputs[0].charAt(0) != 'F' && inputs[0].charAt(0) != 'B') {
            num = Integer.parseInt(inputs[0]) + 3;
        } else if (inputs[1].charAt(0) != 'F' && inputs[1].charAt(0) != 'B') {
            num = Integer.parseInt(inputs[1]) + 2;
        } else {
            num = Integer.parseInt(inputs[2]) + 1;
        }

        String ans;
        if (num % 3 == 0) {
            if (num % 5 == 0) {
                ans = "FizzBuzz";
            } else {
                ans = "Fizz";
            }
        } else {
            if (num % 5 == 0) {
                ans = "Buzz";
            } else {
                ans = String.valueOf(num);
            }
        }
        System.out.println(ans);
    }
}

