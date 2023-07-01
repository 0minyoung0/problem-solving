import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input: while (true) {
			String input = br.readLine();
			
			if (input.equals("0")) return;
			
			int s = 0;
			int e = input.length() - 1;
			while (s < e) {
				if (input.charAt(s++) != input.charAt(e--)) {
					System.out.println("no");
					continue input;
				}
			}
			System.out.println("yes");
		}
		
	}
}
