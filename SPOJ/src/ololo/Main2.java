package ololo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		for (int i = 0; i < t; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		/*
		 * for (int i : arr) System.out.println(i);
		 */
		if (arr[0] != arr[1])
			System.out.println(arr[0]);
		else if (arr[t - 1] != arr[t - 2])
			System.out.println(arr[t - 1]);
		else {
			int prev, curr;
			for (int i = 1; i < t - 1; i++) {
				prev = arr[i] ^ arr[i - 1];
				curr = arr[i] ^ arr[i + 1];
				if (prev != 0 && curr != 0) {
					System.out.println(arr[i]);
					break;
				}
			}
		}
	}
}