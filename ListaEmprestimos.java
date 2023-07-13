package projetos;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEmprestimos implements Iterable<Emprestimo> {

    private static ArrayList<Emprestimo> emprestimos;

    public ListaEmprestimos() {
        super();
        emprestimos = new ArrayList<Emprestimo>();
    }

    public void addEmprestimo(Emprestimo e) {
        emprestimos.add(e);
    }

    public Iterator<Emprestimo> iterator() {
        return emprestimos.iterator();
    }
}