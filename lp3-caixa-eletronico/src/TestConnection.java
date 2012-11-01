import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/caixa", "postgres", "senacrs");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id FROM contas");

		System.out.printf("Contas\n=====\n");

		while (rs.next()) {
			int x = rs.getInt("id");
			System.out.printf("%d\n", x);

		}
	}
}