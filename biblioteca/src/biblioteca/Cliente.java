



package biblioteca;

public class Cliente {
	private int id;
	private String numeroCadastro;
	private String cpfCliente;

	public Cliente(int id, String numeroCadastro, String cpfCliente) {
		super();
		this.id = id;
		this.numeroCadastro = numeroCadastro;
		this.cpfCliente = cpfCliente;
	}

	public int getId() {
		return id;
	}

	public String getNumeroCadastro() {
		return numeroCadastro;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	@Override
	public String toString() {
		return String.format("Cadastro [id=%s, numeroCadastro=%s, cpfCliente=%s]",
				id, numeroCadastro, cpfCliente);
	}
}
