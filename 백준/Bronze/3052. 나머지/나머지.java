import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 나머지 배열
        int[] rem = new int[42];
        
        for (int i=0; i<10; i++) {
        	rem[Integer.parseInt(br.readLine()) % 42]++;
        }
        
        int ans = 0;
        
        for (int i=0; i<42; i++) {
        	if (rem[i] != 0) {
        		ans++;
        	}
        }
        
        System.out.println(ans);
    }
}