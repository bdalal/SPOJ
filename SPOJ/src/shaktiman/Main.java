package shaktiman;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws InterruptedException {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		s.nextLine();
		String[] res = new String[tc];
		for (int i = 0; i < tc; i++) {
			int t = s.nextInt();
			s.nextLine();
			if (t % 2 == 0)
				res[i] = "Thankyou Shaktiman";
			else
				res[i] = "Sorry Shaktiman";
		}
		for (int i = 0; i < tc; i++)
			System.out.println(res[i]);
	}
}