package br.com.xti.java.io;

import java.io.File;
import java.io.IOException;

public class TesteFileClass {

	public static void main(String[] args) throws IOException {

		File file = new File("E:/Dropbox/_Projects - JAVA/xti-orientacao/files/TestePaths/", "Arquivo 2.txt");
		System.out.println(file.getPath());
		System.out.println(file.getName());
		System.out.println(file.getParentFile());

		file.createNewFile();

	}

}
