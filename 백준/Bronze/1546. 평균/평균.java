import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mx = 0;
		int sum = 0;
		for (int i=0; i<n; i++) {
			int temp = sc.nextInt();
			sum += temp;
			if (temp > mx) mx = temp;
		}
		System.out.println((double) sum / mx / n * 100);;
	}
}
