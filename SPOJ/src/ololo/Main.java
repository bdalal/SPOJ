package ololo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		HashSet<Integer> hs = new HashSet<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int i = 0;

		for (i = 0; i < t; i++) {
			int o = Integer.parseInt(br.readLine());
			if (!hs.add(o))
				hs.remove(o);
		}
		Iterator it = hs.iterator();
		System.out.println(it.next());
	}
}