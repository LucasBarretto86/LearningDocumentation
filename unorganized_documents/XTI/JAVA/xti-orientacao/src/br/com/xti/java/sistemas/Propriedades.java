package br.com.xti.java.sistemas;

import java.util.Properties;
import java.util.Set;

public class Propriedades {

	public static void main(String[] args) {

		/* Getting Properties do sistema do usuário*/
		Properties p = System.getProperties();	 // Coleta as propriedades e guarda em uma variavel
		System.out.println(p.getProperty("Java.verson")); // Printa uma propeirade especifica obtida na variavel p
		
		
		p.setProperty("xti.java", "1.0.0");  // Set uma propriedade especifica, por exemplo a versao da sua aplicadação 
	
		
		/* Abaixo está senfo feito um Set, um mapeamento de todas as propriedades do sistema do usuário. */
		Set<Object> pk = p.keySet();
		for (Object key : pk) {
			System.out.println(key + " = " + p.get(key));
		}

	}

}
