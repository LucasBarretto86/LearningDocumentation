package br.com.xti.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncluirDadosNoBanco {

	public static void main(String[] args) {
		Connection con = new ConexaoComOBanco().getConnection(); // Retorna uma conexao
		

		String sql = "insert into pessoas values(?, ?, ?, ?)"; // Estabelece o comando SQL com os valores dinamicos 
		
		String[] pessoas = {"Rafael", "Igor", "Ronie", "Gabriel", "Nicolas", "Amauri" }; // Array apenas para preencher a table neste exemplo

		try (PreparedStatement stmt = con.prepareStatement(sql)) { // Tenta criar o preparedStatement com base na variavel sql
			for (int i = 0; i < pessoas.length; i++) { // Percorre o Array para inserção para a definição da dinamica de inserção de dados.
				stmt.setInt(1, i+4); // indica que o primeiro item '?' da query deverá ser I + 4, pois a principio já havia sido inserido 3 itens, int i = 0
				stmt.setString(2, pessoas[i]); // indica que o item '?' 2 da query dever o item i do array
				stmt.setString(3, "M"); // indica que o item '?' 3 deverá ser M
				stmt.setString(4, pessoas[i].toLowerCase() + "@kit3sentertainment.com"); // indica que o item 4 deve ser o item i do array em lowercase + o complemento concatenado 
				stmt.addBatch(); // add o item i do momento à um bloque de queries, uma Batch de queries
			}
			
			stmt.executeBatch(); // depois de percorrido todos os itens executa todos as queries do bloco
			
		} catch (SQLException e) {
			System.out.println("Erro de inserção de dados, dados duplicados possivelmente");
			e.printStackTrace();
		} finally {
			new ConexaoComOBanco().getList(con); // chama a lista com base no metodo da classe da aula anterior
		}
	}

}
