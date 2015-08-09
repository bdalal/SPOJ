package lastdigit;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		BigInteger[] lastdig = new BigInteger[t];
		s.nextLine();
		for (int i = 0; i < t; i++) {
			String tc = s.nextLine();
			BigInteger a = new BigInteger(tc.substring(0, tc.indexOf(' ')));
			BigInteger b = new BigInteger(tc.substring(tc.indexOf(' ') + 1));
			lastdig[i] = a.modPow(b, BigInteger.TEN);
		}
		for (BigInteger i : lastdig)
			System.out.println(i);
	}
}