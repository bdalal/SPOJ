package bytelandian_cryptographer.act1;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static final BigInteger TWO = new BigInteger("2");
	static final BigInteger ONE = BigInteger.ONE;
	static final BigInteger ZERO = BigInteger.ZERO;
	static final BigInteger FOUR = new BigInteger("4");
	static final BigInteger THREE = new BigInteger("3");
	static final BigInteger _ONE = new BigInteger("-1");
	static final BigInteger THOUSAND = new BigInteger("1000");

	public static void main(String args[]) throws ParseException {
		BigInteger a = new Scanner(System.in).nextBigInteger();
		BigInteger p = new BigInteger("4000000007");		
		Calendar cal = Calendar.getInstance();
		BigInteger limit = new BigInteger("1896114600199");
		
		BigInteger x = quad_congruence(a, p);
		BigInteger x2 = p.subtract(x);

		if(x.multiply(THOUSAND).compareTo(limit) < 1){
			cal.setTimeInMillis(x.longValueExact() * 1000);			
			System.out.println(formatDate(cal.getTime().toString()));
		}
		else{
			cal.setTimeInMillis(x2.longValueExact() * 1000);			
			System.out.println(formatDate(cal.getTime().toString()));
		}
	}

	public static BigInteger legendre(BigInteger a, BigInteger p) {
		BigInteger ls = a.modPow((p.subtract(ONE)).divide(TWO), p);
		if (ls.compareTo(p.subtract(ONE)) == 0)
			return _ONE;
		return ls;
	}

	public static BigInteger quad_congruence(BigInteger a, BigInteger p) {

		a = a.mod(p);
		if (a.compareTo(ZERO) == 0)
			return ZERO;
		if (p.compareTo(TWO) == 0)
			return a;

		if (legendre(a, p).compareTo(ONE) != 0)
			return _ONE;

		if (p.mod(FOUR).compareTo(THREE) == 0)
			return a.modPow((p.add(ONE)).divide(FOUR), p);

		BigInteger q = p.subtract(ONE);
		BigInteger s = ZERO;
		while (q.mod(TWO).compareTo(ZERO) == 0) {
			s = s.add(ONE);
			q = q.divide(TWO);
		}

		BigInteger z = ONE;
		while (legendre(z, p).compareTo(ONE) != 0)
			z = z.add(ONE);
		
		BigInteger c = z.modPow(q, p);
		BigInteger x = a.modPow((q.add(ONE)).divide(TWO), p);
		BigInteger t = a.modPow(q, p);
		BigInteger m = s;

		while (t != _ONE) {
			BigInteger i = ZERO;
			BigInteger e = TWO;
			for (i = ZERO; i.compareTo(m) < 0; i = i.add(ONE)) {
				if (t.modPow(e, p) == ONE)
					break;
				e = e.multiply(TWO);
			}
			BigInteger b = c.modPow((TWO.mod(m.subtract(i.subtract(ONE)))), p);
			x = (x.multiply(b)).mod(p);
			t = (t.multiply(b).multiply(b)).mod(p);
			c = (b.multiply(b)).mod(p);
			m = i;
		}
		return x;
	}

	private static String formatDate(String d) {
		Pattern pattern = Pattern.compile(" [A-Z*]{3}");
		Matcher m = pattern.matcher(d);
		m.find();
		return d.replace(d.substring(m.end() - 4, m.end()), "");
	}
}