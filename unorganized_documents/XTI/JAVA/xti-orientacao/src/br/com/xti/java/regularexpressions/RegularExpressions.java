package br.com.xti.java.regularexpressions;

public class RegularExpressions {

	public static void main(String[] args) {
		String r = "o rato roeu a roupa do rei de roma";

		r = r.replaceAll("\\s", "\t");
		System.out.println(r);

		r = r.replaceAll("r", "g");
		System.out.println(r);
	}

}
