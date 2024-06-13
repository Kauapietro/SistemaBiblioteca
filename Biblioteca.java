import java.util.LinkedList;

public class Biblioteca {
   private LinkedList<Livro> dados;

   public Biblioteca(){
    dados = new LinkedList<Livro>();
   }

   public void inserir(Livro livro) {
    if (dados.contains(livro)) {
        System.out.println(livro + "-Livro duplicado-");
} else{dados.add(livro);}

}
    public void listarTodos(){
        System.out.println("ID\tTitulo\t\t\tano\t\tautor");
        for (Livro livro : dados) {
            String aux = livro.getId() + "\t" + livro.getTitulo() + "\t\t" + livro.getAno()   + "\t\t" + livro.getAutor();
            System.out.println(aux);
            
        }
     
    }

    public Livro BuscaLivros(int id){
        for (Livro livro : dados) {
            if (livro.getId() == id){
                System.out.println("Livro" + livro);
                return livro;}
            }  
            System.out.println("Não encontrado");
            return null;
   
            
            
        }

    public void Remocao(int id) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == id) {
                dados.remove(i);
                System.out.println("Livro removido com sucesso.");
                return;
            }
        }
            System.out.println("Livro com o id " + id + " não encontrado.");
        }

        
}