package projetos;

import java.util.ArrayList;

public class Pessoa {

	// atributos
	private String nome;
	private String cpf;
	private String telefone;
	private ArrayList<Emprestimo> livrosEmprestados;

	//metodo construtor
	public Pessoa(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.livrosEmprestados = new ArrayList<>();

	}

	//metodos

	public void addEmprestimo(Emprestimo emprestimo){
		livrosEmprestados.add(emprestimo);
	}


	// Getters e Setters
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Emprestimo> getLivrosEmprestados(){
		return this.livrosEmprestados;
	}
	
	public void setLivrosEmprestados(ArrayList<Emprestimo> livrosEmprestados){
		this.livrosEmprestados = livrosEmprestados;
	}


}