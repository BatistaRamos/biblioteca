package estante;

public class Operacao {

	private int id;
	private int user;
	private double titulo;
	
	public Operacao(int id, int user, double titulo) {
		super();
		this.id = id;
		this.user = user;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public int getuser() {
		return user;
	}

	public double gettitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		return String.format("Operacao [id=%s, user=%s, titulo=%s]", id, user,
				titulo);
	}
	
	
}
