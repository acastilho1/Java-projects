package projetos;

public class Livro {

	// atributos
	private String titulo;
	private double preco;
	private int qtd;
	private int codigo;
	private boolean disponivel;

	// metodo construtor
	public Livro(String titulo, int qtd, double preco) {
		this.titulo = titulo;
		this.qtd = qtd;
		this.preco = preco;
		this.codigo = CadastroLivro.codigo();
		this.disponivel = true;

	}

	// Getters e Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getQtd() {
		return this.qtd;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean getDisponivel() {
		return this.disponivel;
	}
}