package projetos;

public class Aps {
    public static void main(String[] args) {
        
        Biblioteca b1 = new Biblioteca();
        Livro l1 = new Livro("Harry Potter", 3, 50.00);
        Pessoa p1 = new Pessoa("Leandro", "07963813648", "996110405");
        Pessoa p2 = new Pessoa("Arthur","41654248894", "991349353");


        b1.pessoas.cadastrar(p1);
        b1.pessoas.cadastrar(p2);

        b1.livros.addLivro(l1);
        
        b1.menu();
        
        

    }
}