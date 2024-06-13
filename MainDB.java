public class MainDB {
    public static void main(String[] args) {
        Livro liv = new Livro("O senhor dos aneis");
        liv.setAutor("Tolkien");
        liv.setAno("1954");

        LivroDAO objDAO = new LivroDAO();
        objDAO.inserir(liv);
    
}
}
