package br.com.xti.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class TesteSerializacao {

	public static void main(String[] args) {

		/* GRAVANDO OBJETO */ // Somente objetos que implementam java.io.serializable pode ser gravados.

		String[] nomes = { "Lucas", "Daniel", "Rafael" };

		/* ESCRITA DE OBJETO */

		try (FileOutputStream fos = new FileOutputStream(
				"E:/Dropbox/_Projects - JAVA/xti-orientacao/files/objetos/obj.ser")) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(nomes);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		/* LEITURA DE OBJETO */

		try (FileInputStream fis = new FileInputStream(
				"E:/Dropbox/_Projects - JAVA/xti-orientacao/files/objetos/obj.ser")) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			String[] nomes1 = (String[]) ois.readObject();
			ois.close();
			System.out.println(Arrays.toString(nomes1));

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
