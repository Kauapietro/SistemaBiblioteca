public class MainDB {
    public static void main(String[] args) {
        Livro obj1= new Livro("Calculo I");
        obj1.setAutor("guanabaro");
        obj1.setAno("2020");
        //System.out.println(obj1);
        Livro obj2 = new Livro("ED.dados");
        obj2.setAutor("heisenberg");
        obj2.setAno("2021");
        //System.out.println(obj2);
        Livro obj3 = new Livro("Banco de Dados");
        obj3.setAutor("Amado Batista");
        obj3.setAno("2022");
        //System.out.println(obj3);

        // instanciar biblioteca
        Biblioteca bib = new Biblioteca();
        bib.inserir(obj1); //inserção de cada livro na biblioteca
        bib.inserir(obj2); //insercão de cada livro na biblioteca
        bib.inserir(obj3); //inserção de cada livro na biblioteca

        bib.listarTodos(); //listar todos os livros

        System.out.println("Buscando livro");
        bib.BuscaLivros(2); // busca o livro pelo ID
        //bib.Remocao(1); // remocao o livro pelo id
        bib.listarTodos(); // listar todos os livro na bib
        
    }
    
}
