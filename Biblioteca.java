package projetos;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Biblioteca {

	// atributo uma lista de livros que vem da classe Livro (livros cadastrados,
	// livros emprestados)
	CadastroPessoa pessoas = new CadastroPessoa();
	CadastroLivro livros = new CadastroLivro();
	ListaEmprestimos emprestimos = new ListaEmprestimos();

	Scanner sc = new Scanner(System.in);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void menu() {
		int menu;

		do {
			System.out.println("---------------MENU------------------");
			System.out.println("1- CADASTRAR USUARIO");
			System.out.println("2- CADASTRAR LIVRO");
			System.out.println("3- REALIZAR UM EMPRESTIMO");
			System.out.println("4- SEUS LIVROS EMPRESTADOS");
			System.out.println("5- BUSCAR LIVRO POR TITULO");
			System.out.println("6- REALIZAR UMA DEVOLUÇÃO");
			System.out.println("7- EXIBIR TODOS OS LIVROS");
			System.out.println("0- SAIR");
			System.out.print("\n" + "DIGITE SUA OPÇÃO: ");
			System.out.println("");

			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
				case 0:
					System.out.println("ATÉ MAIS :)");
					break;
				case 1:
					this.novaPessoa();
					break;
				case 2:
					this.novoLivro();
					break;
				case 3:
					this.emprestimo();
					break;
				case 4:
					this.buscaPorPessoa();
					break;
				case 5:
					this.buscarPorTitulo();
					break;
				case 6:
					this.devolucao();
					break;
				case 7:
					this.exibeLivros();
					break;
				default:
					System.out.println("Você digitou uma opção inexistente.");

			}

		} while (menu != 0);
	}

	// cadastrar novos usuarios
	public void novaPessoa() {
		Pessoa pessoa;
		String nome;
		String cpf;
		String telefone;

		System.out.println("--------------ADICIONAR PESSOA-------------");
		System.out.print("NOME: ");
		nome = sc.nextLine();
		System.out.print("CPF: ");
		cpf = sc.nextLine();
		System.out.print("TELEFONE: ");
		telefone = sc.nextLine();

		pessoa = new Pessoa(nome, cpf, telefone);
		pessoas.cadastrar(pessoa);

		System.out.println("");

	}

	// adicionar um novo livro na biblioteca
	public void novoLivro() {
		Livro livro;
		String titulo;
		int qtd;
		double preco;

		System.out.println("------------ADICIONAR LIVRO-----------");
		System.out.print("TITULO: ");
		titulo = sc.nextLine();
		System.out.print("PREÇO: ");
		preco = sc.nextDouble();
		System.out.print("QUANTIDADE: ");
		qtd = sc.nextInt();
		sc.nextLine();

		livro = new Livro(titulo, qtd, preco);
		livros.addLivro(livro);
		System.out.println("");
	}

	// realizar um emprestimo
	public void emprestimo() {
		int livroIndice;
		String cpfUsuario;
		Emprestimo emprestimo;
		boolean cpfValido = false;
		boolean codValido = false;

		System.out.println("------------EMPRESTIMOS-----------");
		System.out.println("");
		this.exibeLivros();

		System.out.print("DIGITE O SEU CPF: ");
		cpfUsuario = sc.nextLine();

		System.out.print("DIGITE O CODIGO DO LIVRO QUE DESEJA ALUGAR: ");
		livroIndice = sc.nextInt();
		sc.nextLine();

		System.out.println("");

		for (Pessoa p : pessoas) {
			if (p.getCpf().equals(cpfUsuario)) {
				for (Livro l : livros) {
					if (l.getCodigo() == livroIndice) {
						codValido = true;
						if (l.getDisponivel() == true) {
							l.setQtd(l.getQtd() - 1);
							emprestimo = new Emprestimo(cpfUsuario, p.getNome(), l.getTitulo(), livroIndice);
							emprestimos.addEmprestimo(emprestimo);
							p.addEmprestimo(emprestimo);

							System.out.println(
									p.getNome().toUpperCase() + " ALUGOU O LIVRO: " + l.getTitulo().toUpperCase());
							System.out
									.println("DATA DE EMPRESTIMO: " + emprestimo.getDiaEmprestimo().format(formatter));
							System.out.println("DATA DE DEVOLUÇÃO: " + emprestimo.getDiaDevolucao().format(formatter));
							break;

						} else {
							System.out.println("DESCULPE, ESTE LIVRO NÃO ESTA DISPONIVEL");
							break;
						}
					}
				}
				cpfValido = true;
			}
		}
		if (cpfValido == false) {
			System.out.println("O USUARIO DESTE CPF NAO EXISTE, VERIFIQUE SE DIGITOU CORRETAMENTE");
		}
		if (codValido == false) {
			System.out.println("O LIVRO DIGITADO NÃO EXISTE, VERIFIQUE SE DIGITOU O CODIGO CORRETO");
		}
		System.out.println("");
	}

	// busca um usuario e exibe seus livros emprestados
	public void buscaPorPessoa() {
		String cpfUsuario;
		System.out.println("--------------BUSCAR PESSOA------------");

		System.out.print("DIGITE SEU CPF: ");
		cpfUsuario = sc.nextLine();
		this.exibeEmprestimos(cpfUsuario);

		System.out.println("");
	}

	// lista livros emprestados por pessoa
	public void exibeEmprestimos(String cpf) {
		boolean cpfValido = false;

		System.out.println("");
		System.out.println("------------------LIVROS ALUGADOS--------------");
		System.out.println("");

		for (Pessoa p : pessoas) {
			if (p.getCpf().equals(cpf)) {
				cpfValido = true;
				for (int i = 0; i < p.getLivrosEmprestados().size(); i++) {
					System.out.println("TITULO: " + p.getLivrosEmprestados().get(i).getTitulo());
					System.out.println("DATA DE EMPRESTIMO: "
							+ p.getLivrosEmprestados().get(i).getDiaEmprestimo().format(formatter));
					System.out.println("DATA DE DEVOLUÇÃO: "
							+ p.getLivrosEmprestados().get(i).getDiaDevolucao().format(formatter));
					System.out.println("");
					System.out.println("");
				}
				break;
			}
		}
		if (cpfValido == false) {
			System.out.println("O USUARIO DESTE CPF NAO EXISTE, VERIFIQUE SE DIGITOU CORRETAMENTE");
		}
	}

	// metodo para procurar livros por titulo
	public void buscarPorTitulo() {
		String titulo;
		boolean tituloValido = false;

		System.out.println("--------------BUSCA (POR TITULO)----------");
		System.out.print("DIGITE O NOME DO LIVRO A SER BUSCADO: ");
		titulo = sc.nextLine();
		System.out.println("");

		// percorre a lista fazendo comparacoes entre o titulo e a lista
		for (Livro l : livros) {
			if (l.getTitulo().equalsIgnoreCase(titulo)) {
				tituloValido = true;
				System.out.println("TITULO: " + l.getTitulo());
				System.out.println("PREÇO: " + l.getPreco());
				if (l.getQtd() > 0) {
					System.out.println("QUANTIDADE: " + l.getQtd());
				} else {
					System.out.println("LIVRO INDISPONIVEL");
				}
				break;
			}
		}
		if (tituloValido == false) {
			System.out.println("O LIVRO BUSCADO NÃO EXISTE, VERIFIQUE SE DIGITOU O TITULO CORRETAMENTE.");
		}

		System.out.println("");
	}

	// metodo realizar devolucao
	public void devolucao() {
		String cpf;
		String titulo;
		boolean cpfValido = false;

		System.out.println("----------------DEVOLUÇÃO------------");
		System.out.println("");
		System.out.print("DIGITE SEU CPF: ");
		cpf = sc.nextLine();
		this.exibeEmprestimos(cpf);
		System.out.println("");
		System.out.print("DIGITE O TITULO DO LIVRO QUE DESEJA DEVOLVER: ");
		titulo = sc.nextLine();

		for (Pessoa p : pessoas) {
			if (p.getCpf().equals(cpf)) {
				cpfValido = true;
				for (Emprestimo e : p.getLivrosEmprestados()) {
					if (e.getTitulo().equalsIgnoreCase(titulo)) {
						p.getLivrosEmprestados().remove(e);
						System.out.println("DEVOLUÇÃO FEITA COM SUCESSO :)");
						break;
					}
				}
			}
		}

		if (cpfValido == false) {
			System.out.println("O USUARIO DESTE CPF NAO EXISTE, VERIFIQUE SE DIGITOU CORRETAMENTE");
		}

		// adiciona o livro novamente a biblioteca
		for (Livro l : livros) {
			if (l.getTitulo().equalsIgnoreCase(titulo)) {
				l.setQtd(l.getQtd() + 1);
			}
		}
	}

	// exibe todos os livros
	public void exibeLivros() {

		System.out.println("---------------LIVROS---------------");

		for (Livro l : livros) {
			System.out.println(l.getCodigo() + ": " + l.getTitulo());
		}
		System.out.println("");
	}

}