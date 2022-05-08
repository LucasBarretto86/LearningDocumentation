package br.com.xti.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaCRUD {

	public Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/xti?useSSL=false", "root", "xiaojiao");

		} catch (SQLException e) {
			System.out.println("Erro de conexão!");
			e.printStackTrace();
		}

		return null;
	}

	public List<Conta> list(Connection con) {
		List<Conta> lista = new ArrayList<>();
		String sql = "select numero, cliente, saldo from conta";

		try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				lista.add(new Conta(rs.getInt(1), rs.getString(2), rs.getDouble(3)));

			}
		} catch (SQLException e) {
			System.out.println("Erro ao detalhar tabela de contas!");
			e.printStackTrace();
		}
		return lista;
	}

	public void create(Connection con, Conta conta) {
		String sql = "insert into conta values(?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, conta.getNumero());
			stmt.setString(2, conta.getCliente());
			stmt.setDouble(3, conta.getSaldo());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir nova conta!");
			e.printStackTrace();
		}
	}

	public void update(Connection con, Conta conta) {
		String sql = "update conta set cliente=?, saldo=? where numero=? ";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, conta.getCliente());
			stmt.setDouble(2, conta.getSaldo());
			stmt.setInt(3, conta.getNumero());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar conta!");
			e.printStackTrace();
		}
	}

	public void delete(Connection con, Conta conta) {
		String sql = "delete from conta where numero=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, conta.getNumero());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao deletar conta!");
			e.printStackTrace();
		}
	}

	public boolean transfer(Connection con, double valor, Conta origem, Conta destino) {
		try {
			if (origem.transfere(valor, destino)) {
				con.setAutoCommit(false);
				update(con, origem);
				update(con, destino);
				System.out.println("Transferencia Ok!");
				con.commit();
				return true;

			} else {
				try {
					con.rollback();
					System.out.println("Transferencia Abortada!");
				} catch (SQLException x) {
					System.out.println("Erro ao retornar ao status original!");
					x.printStackTrace();
				}
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {

		/* CRIAÇÃO DA CONEXÃO E DO CRUD */
		Connection c = new ContaCRUD().getConnection();
		ContaCRUD crud = new ContaCRUD();

		Conta conta1 = new Conta(5005, "Lucas", 2_000.00);
		Conta conta2 = new Conta(4879, "Rafael", 8_000.00);
		Conta conta3 = new Conta(4953, "Daniel", 6_000.00);

		/* INDEXNANDO A TABELA USANDO METODO DO CRUD */
		crud.create(c, conta1);
		crud.create(c, conta2);
		crud.create(c, conta3);

		List<Conta> lista1 = crud.list(c);
		for (Conta conta : lista1) {
			System.out.println(conta.toString());
		}
		System.out.println("Contas Adicionadas!\n");

		/* MODIFICAÇÃO DA CONTA E USO DO METODO DE ATUALIZAÇÃO */
		conta1.setCliente("Mendonça");
		conta2.setCliente("Virgulino");
		conta3.setCliente("Tapióca");

		crud.update(c, conta1);
		crud.update(c, conta2);
		crud.update(c, conta3);

		List<Conta> lista2 = crud.list(c);
		for (Conta conta : lista2) {
			System.out.println(conta.toString() + "\tAtualizada!");
		}
		System.out.println("Contas Modificadas!\n");

		/* METODO DE TRANSFERENCIA */
		if (crud.transfer(c, 2_000, conta1, conta3)) {
			List<Conta> lista3 = crud.list(c);
			for (Conta conta : lista3) {
				System.out.println(conta.toString());
			} 				
			System.out.println();
			} else {
		}
		System.out.println();
		
		/* PERCORRENDO LISTA E DELETANDO */
		List<Conta> lista4 = crud.list(c);
		for (Conta conta : lista4) {
			crud.delete(c, conta);
			System.err.println(conta.toString() + "\tExcluida!");
		}
		System.out.println("Contas Excluidas!\n");
	}
}
