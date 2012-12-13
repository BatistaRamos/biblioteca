package estante;

public class User {
	private int id;
	private String numerouser;
	private String cpfCliente;

	public User(int id, String numerouser, String cpfCliente) {
		super();
		this.id = id;
		this.numerouser = numerouser;
		this.cpfCliente = cpfCliente;
	}

	public int getId() {
		return id;
	}

	public String getNumerouser() {
		return numerouser;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	@Override
	public String toString() {
		return String.format("user [id=%s, numerouser=%s, cpfCliente=%s]",
				id, numerouser, cpfCliente);
	}
}
