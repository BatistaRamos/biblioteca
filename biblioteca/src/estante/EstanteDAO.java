package estante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//----------------------------------------------------------------------------------//

public class EstanteDAO {

	private static final String selectFinduser = "select * from contas where numero = 'Batista' and senha = 'a' ";
	private static final String insertOperacao = "insert into biblioteca(titulo) values (Os luziadas, Batista)";
	private static final String selectconsultarLivro = "select * from biblioteca where titulo = ?";
	
	
	
	

//----------------------------------------------------------------------------------//
	
	
	public User finduser(String numero, String senha) {
		if (numero == null) {
			throw new IllegalArgumentException(
					"O número da user não pode ser null.");
		}
		if (senha == null) {
			throw new IllegalArgumentException(
					"A senha da user não pode ser null.");
		}
		User c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/estante", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectFinduser);
			stmt.setString(1, numero);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String cpf = rs.getString("cpf");
				String num = rs.getString("numero");
				c = new User(id, num, cpf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return c;
	}

	public void depositar(User c, String v) {
		if (c == null) {
			throw new IllegalArgumentException("A user não pode ser null!");
		}
		//if (v <= 0.01) {
		//	throw new IllegalArgumentException(
		//			"O titulo deve ser maior ou igual a um centavo!");
		//}

	/*	try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/estante", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(insertOperacao);
			stmt.setInt(1, c.getId());
			stmt.setDouble(2, v);
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir operação");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		*/
		// FIXME: fechar conexões
	}
	
	public List<Operacao> consultarLivro(User c) {
		if (c == null) {
			throw new IllegalArgumentException(
					"A user não pode ser null.");
		}
		List<Operacao> ops = new ArrayList<Operacao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/estante", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectconsultarLivro);
			stmt.setInt(1, c.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int user = rs.getInt("user");
				double titulo = rs.getDouble("titulo");
				Operacao op = new Operacao(id, user, titulo);
				ops.add(op);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return ops;
	}
	

	public static void main(String[] args) {
		EstanteDAO estante = new EstanteDAO();
		User c = estante.finduser("Batista", "a");
	

		
		if (c == null) {
			System.out.println("user não encontrada!");
			
		} else {
			System.out.println(c);
			estante.depositar(c, 112.45);
			System.out.println(estante.consultarLivro(c));
		}
	}
}

