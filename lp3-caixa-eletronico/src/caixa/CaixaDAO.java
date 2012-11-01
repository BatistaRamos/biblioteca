package caixa;

public class CaixaDAO {

	public Conta findConta(String numero, String senha) {
		if (numero == null) {
			throw new IllegalArgumentException("O n�mero da conta n�o pode ser null.");
		}
		if (senha == null) {
			throw new IllegalArgumentException("A senha da conta n�o pode ser null.");
		}
		Conta c = null;
		
		//TODO: SELECT
		
		return c;
	}
	
	public void depositar(Conta c, double valor) {
		if (c == null) {
			throw new IllegalArgumentException("A conta n�o pode ser null!");
		}
		if (valor <= 0.01) {
			throw new IllegalArgumentException("O valor deve ser maior ou igual a um centavo!");
		}
		
		//TODO: INSERT

	}	
}