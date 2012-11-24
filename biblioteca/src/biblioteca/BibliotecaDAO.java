package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import biblioteca.Cliente;

public class BibliotecaDAO {





	private static final String selectFindcadastro = "select * from clientes where numeroCadastro = 1 and ";
	private static final String insertOperacao = "insert into operacoes(livroemprestado, livrodevolvido) values (?, ?)";

	
	public Cliente findcadastro(String numero, String senha) {
		if (numero == null) {
			throw new IllegalArgumentException(
					"O n�mero da cadastro n�o pode ser null.");
		}
		if (senha == null) {
			throw new IllegalArgumentException(
					"A senha da cadastro n�o pode ser null.");
		}
		Cliente c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/biblioteca", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(selectFindcadastro);
			stmt.setString(1, numero);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String cpf = rs.getString("cpf");
				String num = rs.getString("numero");
				c = new Cliente(id, num, cpf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conex�es

		return c;
	}

	public void depositar(Cliente c, double valor) {
		if (c == null) {
			throw new IllegalArgumentException("A cadastro n�o pode ser null!");
		}
		if (valor <= 0.01) {
			throw new IllegalArgumentException(
					"O valor deve ser maior ou igual a um centavo!");
		}

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/caixa", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(insertOperacao);
			stmt.setInt(1, c.getId());
			stmt.setDouble(2, valor);
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir opera��o");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conex�es
	}

	public static void main(String[] args) {
		BibliotecaDAO caixa = new BibliotecaDAO();
		Cliente c = caixa.findcadastro("100", "123");
		if (c == null) {
			System.out.println("cadastro n�o encontrado!");
		} else {
			System.out.println(c);
			caixa.depositar(c, 112.45);
		}
	}
}