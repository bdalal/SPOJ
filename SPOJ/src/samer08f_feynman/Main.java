package samer08f_feynman;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> t = new ArrayList<Integer>();
		int temp;
		while (true) {
			temp = s.nextInt();
			if (temp == 0)
				break;
			t.add(temp);
			s.nextLine();
		}
		int n;
		for (int i = 0; i < t.size(); i++) {
			n = t.get(i);
			System.out.println((n * (n + 1) * (2 * n + 1)) / 6);
		}
	}
}