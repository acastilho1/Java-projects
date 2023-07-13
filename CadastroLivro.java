package projetos;

import java.util.ArrayList;
import java.util.Iterator;

public class CadastroLivro implements Iterable<Livro> {

    // define um array em que os itens sao objetos Livro
    private static ArrayList<Livro> livros;

    // metodo para cadastrar livro
    public CadastroLivro() {
        // chama o metodo construtor da classe pai
        super();
        livros = new ArrayList<Livro>();
    }

    // metodo para adicionar livros
    public void addLivro(Livro novoLivro) {
        livros.add(novoLivro);
    }

    // metodo para conseguir atribuir Indices a partir de 1 para os livros
    public static int codigo() {
        int index;
        index = livros.size() + 1;

        return index;
    }

    // retorna o tamanho da lista
    public int getLivroSize() {
        return livros.size();
    }

    @Override
    public Iterator<Livro> iterator() {
        return livros.iterator();
    }

}