package br.com.xti.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TesteMoverCopiarExcluirArquivo {

	public static void main(String[] args) throws IOException {

		/* CLASSE PATH E FILES */

		/* DIRETÓRIOS */
		Path dir = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/Novo Diretório");
		// Esbelece uma variavel para o caminho e get o endereço como parametro.

		/* CRIAÇÃO DE DIRETÓRIO */
		Files.createDirectory(dir);
		System.out.println("Criação de pasta Novo Diretório para a variável dir.");
		// Cria o novo diretoryo e faz o sysout do endereço.

		Files.isDirectory(dir);
		System.out.println(Files.isDirectory(dir));
		// Verificação boolean se path declarado trata-se ou não de um diretório, caso
		// seja incluido no path um
		// um arquivo o sistema tras false.

		/* EXCLUSÃO DE DIRETÓRIO */
		Files.deleteIfExists(dir);
		System.out.println("Deletou a pasta, Novo Direrótio da variável dir.\n");
		// Deleta o diretório especificado na variavel dir, porém, se o diretório tiver
		// arquivos não deleta.

		/* ARQUIVO */
		Path path = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/criação/Novo Arquivo.txt");
		Files.createDirectories(path.getParent());
		// Esbeleceu um path já com o nome do arquivo e criou todos os diretórios
		// necessários usando o
		// path.Parent()

		/* CRIAÇÃO DE ARQUIVOS */
		Files.createFile(path);
		Files.write(path, "Novo texto!".getBytes());
		System.out.println(path);
		// demanda a criação do arquivo e escreve um pequeno texto, apenas para o
		// exemplo, depois imprime o
		// endereço explicito na variavel path

		/* VERIFICAÇÃO DE ARQUIVO */
		Files.isReadable(path);
		System.out.println(Files.isReadable(path));
		// Verificação booleana se o arquivo é ou não readable.

		Files.probeContentType(path);
		System.out.println(Files.probeContentType(path));
		// Verificação do tipo de arquivo da variável path

		Files.getLastModifiedTime(path);
		System.out.println(Files.getLastModifiedTime(path));
		// Getta o horário da ultima modifiação do arquivo e a data.

		/* COPIAR ARQUIVO */
		Path copy = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/criação/Copia.txt");
		// Estabelece um path para criação de uma cópia.

		Files.copy(path, copy, StandardCopyOption.REPLACE_EXISTING);
		// Solicita a copia do arquivo, solicitando como parametro a variavel do arquivo
		// de input e o path
		// do arquivo de output, também é possivel pedir que o arquivo seja subscrito
		// caso já exista no campo de
		// options.

		/* MOVER ARQUIVO */
		Path move = Paths.get(path.getParent() + "/move/Novo Arquivo.txt");
		// Estabelece um novo path de destino para o arquivo para mover é necessário
		// informar o mesmo nome
		// de arquivo.

		Files.createDirectories(move);
		// Cria o novo diretório do path.

		Files.move(path, move, StandardCopyOption.REPLACE_EXISTING);
		// instrução para a movimentação do arquivo

		/* EXCLUSÃO DE ARQUIVO */
		Files.deleteIfExists(path);
		Files.deleteIfExists(copy);
		Files.deleteIfExists(copy.getParent());
		// Exclusão dos arquivos nas duas primeiras linhas e exclusão do diretório via
		// getParent().

	}
}
