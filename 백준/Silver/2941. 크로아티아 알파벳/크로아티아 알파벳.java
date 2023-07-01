import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int ans = 0;
        
        for (int i=0; i<s.length(); i++) {
        	if (s.charAt(i) == 'c' && i+1 < s.length()
        		&& (s.charAt(i+1) == '=' || s.charAt(i+1) == '-')) {
        		ans++;
        		i++;
        	}else if (s.charAt(i) == 'd' && i+2 < s.length()
        				&& s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') {
        		ans++;
        		i+=2;
        	}else if (s.charAt(i) == 'd' && i+1 < s.length()
        				&& s.charAt(i+1) == '-') {
        		ans++;
        		i++;
        	}else if (s.charAt(i) == 'l' && i+1 < s.length()
    				&& s.charAt(i+1) == 'j') {
        		ans++;
        		i++;
        	}else if (s.charAt(i) == 'n' && i+1 < s.length()
    				&& s.charAt(i+1) == 'j') {
        		ans++;
        		i++;
        	}else if (s.charAt(i) == 's' && i+1 < s.length()
    				&& s.charAt(i+1) == '=') {
        		ans++;
        		i++;
        	}else if (s.charAt(i) == 'z' && i+1 < s.length()
    				&& s.charAt(i+1) == '=') {
        		ans++;
        		i++;
        	}else {
        		ans++;
        	}
        }
        
        System.out.println(ans);
    }
}