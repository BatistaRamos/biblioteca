package caixa;

public class Conta {
	private int id;
	private String numeroConta;
	private String cpfCliente;

	public Conta(int id, String numeroConta, String cpfCliente) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.cpfCliente = cpfCliente;
	}

	public int getId() {
		return id;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	@Override
	public String toString() {
		return String.format("Conta [id=%s, numeroConta=%s, cpfCliente=%s]",
				id, numeroConta, cpfCliente);
	}
}
