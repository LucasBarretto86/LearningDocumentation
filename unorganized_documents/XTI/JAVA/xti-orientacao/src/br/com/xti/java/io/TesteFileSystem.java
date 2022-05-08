package br.com.xti.java.io;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteFileSystem {

	public static void main(String[] args) throws IOException {

		/* LISTAR DIREÓRIOS */
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();

		for (Path path : dirs) {
			System.out.println(path);

		}

		System.out.println();

		/* LISTAR COTEUDO DE UM PATH */

		Path path = Paths.get("E:/Dropbox/_Projects - JAVA/xti-orientacao");

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path p : stream) {
				System.out.println(p.getFileName());
			}
		} catch (IOException | DirectoryIteratorException e) {
			e.printStackTrace();
		}

		System.out.println();

		/* VERIFICAR DETALHES DOS DIRETÓRIOS */

		FileSystem fs = FileSystems.getDefault();

		for (FileStore store : fs.getFileStores()) {

			System.out.println("Unidade: " + store.toString());
			System.out.println("Total: " + store.getTotalSpace() + " bytes");
			System.out.println("Disponivel: " + store.getUsableSpace() + " bytes");
			System.out.println("Utilizado: " + (store.getTotalSpace() - store.getUsableSpace()) + " bytes\n");

		}

	}

}
