package br.com.xti.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoComOBanco {
	Connection connection;
	
	/**Metodo que retorna uma conexão, dentro do design pattern de ConnectionFactory*/
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/xti?useSSL=false"; // Estabele o entendo do servidor
		String user = "root"; // Estabelece o usuário a ser utilizado para conexão
		String pass = "xiaojiao"; // Estabelece a senha do usuário
		
		/* Tenta estabelecer a conexão, com o uso do DriverManager e retorna uma conexão*/
		try{ 
			System.out.println("Conectado com sucesso!");	
			return this.connection=DriverManager.getConnection(url, user, pass);
				
		} catch (SQLException e) {
			System.out.println("Erro de conexão!");
			e.printStackTrace();
		}
		return null;
	}
	
	/** Metodo que recebe uma conexão e executa uma query que consulta o banco de dados  e printa no console*/
	public void getList(Connection c) {
		String sql = "select codigo, nome, sexo, email from pessoas"; // Especifica a linha de comando sql a ser usada 
		
		/* Multiplos tries 
		 * 
		 * PreparedStatement informa para a conexão qual é o statement que iremos realizar, neste caso indicado a string sql
		 * estabeleciada a cima
		 * 
		 * ResultSet recebe um set  recebido do comando de execução do statement realizado apartir do executeQuery(),
		 * neste caso como iremos receber o dado usamos execute, caso fossemos modificar a table ou excluir um item
		 * usariamos o executeUpdate()*/
		try(PreparedStatement stmt = c.prepareStatement(sql);
			   ResultSet rs = stmt.executeQuery()){
			
			while(rs.next()) { // Traz o comando do bloco enquanto houver um proximo item
				String line = rs.getString("codigo") + "\t "
						+ rs.getString("nome") + "\t "
						+ rs.getString("sexo") + "\t " 
						+ rs.getString("email");
				/* Formata o modo como a string será gerada apartir do recebimento dos dados
				 *  observe que a table sempre retorna como string os elementos do banco de dados.*/	
		
				System.out.println(line); // retorna a linha de acordo com a formatação estipulada na variavel.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try(Connection c = new ConexaoComOBanco().getConnection()){
			new ConexaoComOBanco().getList(c);
		} catch (SQLException e) {
			System.out.println("Erro ao interagir com a Lista");
			e.printStackTrace();
		}
		

	}
}
