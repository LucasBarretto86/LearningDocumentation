package br.com.xti.desafio.datas;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class TesteDatas {

	public static void main(String[] args) {

		Date data = new Date();
		data.getTime();
		System.out.println(data);

		Calendar calendar = Calendar.getInstance();
		calendar.set(1997, Calendar.MAY, 8);
		System.out.println(calendar.getTime());

		System.out.println("\nDateFormat as getInstance");
		DateFormat f1 = DateFormat.getInstance();
		System.out.println(f1.format(data));
		System.out.println(f1.format(calendar.getTime()));

		System.out.println("\nDateFormat as getDateInstance");
		DateFormat f2 = DateFormat.getDateInstance();
		System.out.println(f2.format(data));
		System.out.println(f2.format(calendar.getTime()));

		System.out.println("\nDateFormat as getTimeInstance");
		DateFormat f3 = DateFormat.getTimeInstance();
		System.out.println(f3.format(data));
		System.out.println(f3.format(calendar.getTime()));

		java.sql.Date a = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		System.out.println(a);

	}

}
