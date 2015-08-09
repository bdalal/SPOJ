package ololo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		for (int i = 0; i < t; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int out = 0;
		for (int i = 0; i < t; i++) {
			out ^= arr[i];
		}
		System.out.println(out);
	}

}
