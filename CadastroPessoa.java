package projetos;

import java.util.ArrayList;
import java.util.Iterator;

public class CadastroPessoa implements Iterable<Pessoa> {

    // define um array onde os itens eh o objeto Pessoa
    private static ArrayList<Pessoa> pessoas;

    // metodo para cadastrar pessoas
    public CadastroPessoa() {
        // chama o metodo construtor da classe pai
        super();
        pessoas = new ArrayList<Pessoa>();
    }

    // metodo para cadastrar um usuario
    public void cadastrar(Pessoa p) {
        pessoas.add(p);

    }

    @Override
    public Iterator<Pessoa> iterator() {
        return pessoas.iterator();
    }

}