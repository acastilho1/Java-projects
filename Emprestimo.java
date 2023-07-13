package projetos;

import java.time.LocalDate;

public class Emprestimo {

    //atributos
    private String cpf;
    private String nome;
    private String titulo;
    private int codigoLivro;
    private LocalDate diaEmprestimo;
    private LocalDate diaDevolucao;

    public Emprestimo(String cpf, String nome, String titulo, int codigoLivro){
        this.cpf = cpf;
        this.codigoLivro = codigoLivro;
        this.diaEmprestimo = LocalDate.now();
        this.diaDevolucao = LocalDate.now().plusDays(30);
        this.nome = nome;
        this.titulo = titulo;

    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setCodigoLivro(int codigoLivro){
        this.codigoLivro = codigoLivro;
    }

    public int getCodigoLivro(){
        return this.codigoLivro;
    }

	public void setDiaEmprestimo(LocalDate diaEmprestimo){
		this.diaEmprestimo = diaEmprestimo;
	}

    public LocalDate getDiaEmprestimo(){
		return this.diaEmprestimo;
	}

	public void setDiaDevolucao(LocalDate diaDevolucao){
		this.diaDevolucao = diaDevolucao;
	}

    public LocalDate getDiaDevolucao(){
		return this.diaDevolucao;
	}
    
}