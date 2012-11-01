package caixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CaixaDAO {

	private String selectFindConta = "select * from contas where numero = ? and senha = ?";

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

		// TODO: select * from contas where numero = ? and senha = ?
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
		}
		//

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

		// TODO: INSERT

	}

	public static void main(String[] args) {
		CaixaDAO caixa = new CaixaDAO();
		Conta c = caixa.findConta("1", "a");
		if (c == null) {
			System.out.println("Conta não encontrada!");
		} else {
			System.out.println(c);
		}
	}
}
