import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 벌집 방 번호
		int n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			System.out.println(1);
			return;
		}
		n -= 1;
		
		int floor = 1;
		while (true) {
			n -= floor++ * 6;
			if (n <= 0) {
				break;
			}
		}
		
		System.out.println(floor);
	}
}
