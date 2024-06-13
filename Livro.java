public class Livro {
    private int id;
    private  String titulo;
    private String autor;
    private String ano;
    private static int contador = 0;

    //CONSTRUTOR
    public Livro(String titulo){
        this.setTitulo(titulo);
        contador += 1;
        this.setId(contador);

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }



    public int setId(){
        return id;
    }
    
    public String getTitulo(){
        return this.titulo;
    }

    
    
    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getAno() {
        return ano;
    }


    public void setAno(String ano) {
        this.ano = ano;
    }


    public void setTitulo(String titulo){
        titulo = titulo.toUpperCase();
        this.titulo = titulo;
    }



    @Override
    public String toString() {
        return "Livro [id = " + id + ", titulo = " + titulo + ", ano = " + ano +  ", autor = " + autor + "]"; 
    }

    
}