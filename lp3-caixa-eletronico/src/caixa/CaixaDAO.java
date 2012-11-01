package caixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * A classe <code>CaixaDAO</code> representa um
 * objecto de acesso a dados (data access object - DAO).
 * 
 * Todas as operações em SQL e JDBC da aplicação são 
 * realizadas pelo DAO.
 * 
 * @author marco.mangan@gmail.com
 *
 */
public class CaixaDAO {

	private static final String selectFindConta = "select * from contas where numero = ? and senha = ?";
	private static final String insertOperacao = "insert into operacoes(conta, valor) values (?, ?)";

	/**
	 * Retorna um objeto com os dados da conta indicada
	 * por <code>numero</code> e com a senha <code>senha</code>.
	 * 
	 * @param numero o número da conta, não pode ser null.
	 * @param senha a senha da conta, não pode ser null.
	 * 
	 * @return null caso o número da conta não exista, 
	 * caso contrário, retorna um objeto Conta com os dados da conta
	 * 
	 */
	public Conta findConta(String numero, String senha) {
		if (numero == null) {
			throw new IllegalArgumentException(
					"O número da conta não pode ser null.");
		}
		if (senha == null) {
			throw new IllegalArgumentException(
					"A senha da conta não pode ser null.");
		}
		Conta c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/caixa", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(selectFindConta);
			stmt.setString(1, numero);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String cpf = rs.getString("cpf");
				String num = rs.getString("numero");
				c = new Conta(id, num, cpf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conexões

		return c;
	}

	public void depositar(Conta c, double valor) {
		if (c == null) {
			throw new IllegalArgumentException("A conta não pode ser null!");
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
				throw new RuntimeException("Erro ao inserir operação");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conexões
	}

	public static void main(String[] args) {
		CaixaDAO caixa = new CaixaDAO();
		Conta c = caixa.findConta("1", "a");
		if (c == null) {
			System.out.println("Conta não encontrada!");
		} else {
			System.out.println(c);
			caixa.depositar(c, 112.45);
		}
	}
}
