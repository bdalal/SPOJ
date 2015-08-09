package adv04l;
//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
	// static ArrayList<Long> fibo = new ArrayList<Long>();
	static long[] fibo = new long[74];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		InputReader in = new InputReader(System.in);
		precompute();
//		int t = Integer.parseInt(br.readLine());
		int t = in.readInt();
		long[] inp = new long[t];
		for (int i = 0; i < t; i++)
//			inp[i] = Long.parseLong(br.readLine());
			inp[i] = in.readLong();

		for (int i = 0; i < t; i++)
			System.out.println(miles2kms(inp[i]));
	}

	private static long miles2kms(long l) {
		if (l == 1)
			return 2;
		// int index = fibo.indexOf(l);
		// if (index > -1) {
		// return fibo.get(index + 1);
		// }
		for (int i = 1; i < 74; i++)
			if (fibo[i] == l)
				return fibo[i + 1];
		long num;
		long kms = 0;
		while (l > 0) {
			for (int i = 1; i < 74; i++) {
				// num = fibo.get(i);
				num = fibo[i];
				if (num > l) {
					kms += num;
					// l -= fibo.get(i - 1);
					l -= fibo[i - 1];
					break;
				}
			}
		}
		return kms;
	}

	private static void precompute() {
		long a0 = 1L, a1 = 1L, a2 = 0L;
		// fibo.add(a0);
		// fibo.add(a1);
		fibo[0] = fibo[1] = 1L;
		int i = 2;
		while (a2 <= 1000000000000000L) {
			a2 = a0 + a1;
			// fibo.add(a2);
			fibo[i++] = a2;
			a0 = a1;
			a1 = a2;
		}
		// fibo.remove(0);
		fibo[0] = -1;
	}
	
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
		
		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	}
}