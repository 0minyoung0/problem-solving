import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 점괘
		char[] S = br.readLine().toCharArray();
		
		// YONSEI 카운트
		int cntY = 0;
		char[] Y = {'Y', 'O', 'N', 'S', 'E', 'I'};
		// KOREA 카운트
		int cntK = 0;
		char[] K = {'K', 'O', 'R', 'E', 'A'};
		
		for (int i=0; i<S.length; i++) {
			if (S[i] == Y[cntY]) {
				cntY++;
				if (cntY == 6) {
					System.out.println(Y);
					return;
				}
			}
			if (S[i] == K[cntK]) {
				cntK++;
				if (cntK == 5) {
					System.out.println(K);
					return;
				}
			}
		}
	}
}
