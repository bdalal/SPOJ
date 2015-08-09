package pouringwater;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		int[] g1 = new int[t];
		int[] g2 = new int[t];
		int[] res = new int[t];

		for (int i = 0; i < t; i++) {
			g1[i] = s.nextInt();
			s.nextLine();
			g2[i] = s.nextInt();
			s.nextLine();
			res[i] = s.nextInt();
			s.nextLine();
		}
		for (int i = 0; i < t; i++)
			System.out.println(calcSteps(g1[i], g2[i], res[i]));
	}

	private static int calcSteps(int g1, int g2, int res) {
		int big = 0;
		int small = 0;
		int steps = 0;
		int gcd;
		int max_val = max(g1, g2);
		int min_val = min(g1, g2);

		// If required quantity > size of either cup return -1
		if (res > max_val)
			return -1;

		// If both cups are of same size, then check if required quantity = size
		// of cup
		if (g1 == g2)
			if (res == g1)
				return 1;
			else
				return -1;

		// If required quantity = size of either cup return 1
		if (res == g1 || res == g2)
			return 1;

		gcd = calcGCD(g1, g2);
		// If required quantity not a multiple of GCD of sizes of the two cups,
		// return -1
		if (res % gcd != 0) {
			return -1;
		}

		return min(getStepsb2s(big, small, res, max_val, min_val),
				getStepss2b(big, small, res, max_val, min_val));
	}

	private static int getStepsb2s(int big, int small, int res, int max_val,
			int min_val) {
		int steps = 0;
		while (big != res || small != res) {
			big = max_val;
			steps++;
			while (big > 0) {
				if (big >= min_val - small) {
					big -= min_val - small;
					small = min_val;
				} else {
					small += big;
					big = 0;
				}
				steps++;
				if (big == res || small == res)
					return steps;
				if (big > 0) {
					small = 0;
					steps++;
				}
			}
		}
		return steps;
	}

	private static int getStepss2b(int big, int small, int res, int max_val,
			int min_val) {
		int steps = 0;
		while (big != res || small != res) {
			small = min_val;
			steps++;
			while (small > 0) {
				if (small >= max_val - big) {
					small -= max_val - big;
					big = max_val;
				} else {
					big += small;
					small = 0;
				}
				steps++;
				if (big == res || small == res)
					return steps;
				if (small > 0) {
					big = 0;
					steps++;
				}
			}
		}
		return steps;
	}

	private static int min(int i, int j) {
		if (i < j)
			return i;
		else
			return j;
	}

	private static int max(int i, int j) {
		if (i > j)
			return i;
		else
			return j;
	}

	private static int calcGCD(int i, int j) {
		if (j == 0)
			return i;
		else
			return calcGCD(j, i % j);
	}
}