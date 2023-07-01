import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int ans = 0;
        
        for (int i=1; i*i<=n; i++) {
        	for (int j=i; j*i<=n; j++) {
        		ans++;
        	}
        }
        
        System.out.println(ans);
    }
}