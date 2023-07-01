import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ans = 0;
		while (n != 0) {
			ans += n % 10;
			n /= 10;
		}
		System.out.println(ans);
	}
}