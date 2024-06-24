import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class LivroDAO {
    private ConectaDB conexao;

    public LivroDAO(){
        //Inicializa a conexão com o banco de dados
        conexao = new ConectaDB();
    }

    //Método para inserir um novo livro no banco de dados
    public void inserir(Livro livro){
        String sql = "INSERT INTO livro(titulo, autor, ano) VALUES (?, ?, ?)";
        try (Connection conn = conexao.getConexaoDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            //Define os valores dos parâmetros
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setInt(3, livro.getAno());
            pst.executeUpdate();
            System.out.println("Insercao ok: " + livro);
        } catch (Exception e) {
            System.out.println("Falha na insercao: " + e.getMessage());
        }
    }

    // Método para consultar todos os livros no bd
    public LinkedList<Livro> consultarTodos(){
        String sql = "SELECT * FROM livro";
        LinkedList<Livro> lista = new LinkedList<>();
        try (Connection conn = conexao.getConexaoDB();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet resultados = pst.executeQuery()) {
            while (resultados.next()){
                Livro obj = new Livro(resultados.getString("titulo"));
                obj.setAno(resultados.getInt("ano"));
                obj.setAutor(resultados.getString("autor"));
                obj.setId(resultados.getInt("idLivro"));
                lista.add(obj);
            }
        } catch (Exception e) {
            System.out.println("Falha na consulta: " + e.getMessage());
        }
        return lista;
    }

    //Consultar um livro específico pelo id
    public Livro consultar(int id){
        String sql = "SELECT * FROM livro WHERE idLivro = ?";
        Livro livro = null;
        try (Connection conn = conexao.getConexaoDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet resultado = pst.executeQuery()) {
                //Se encontrar o registro no banco de dados
                if (resultado.next()){
                    //Cria um objeto Livro com os dados bd
                    livro = new Livro(resultado.getString("titulo"));
                    livro.setAno(resultado.getInt("ano"));
                    livro.setAutor(resultado.getString("autor"));
                    livro.setId(id);
                } else {
                    System.out.println("Nao tem registro com id = " + id);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na consulta: " + e.getMessage());
        }
        return livro;
    }

    // Método para excluir um livro pelo id
    public void excluir(int id){
        String sql = "DELETE FROM livro WHERE idLivro = ?";
        try (Connection conn = conexao.getConexaoDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            //Define o valor do parâmetro
            pst.setInt(1, id);
            //Executa o comando SQL
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Exclusao ok para id = " + id);
            } else {
                System.out.println("Nao ha registro para excluir com id = " + id);
            }
        } catch (Exception e) {
            System.out.println("Falha na exclusao: " + e.getMessage());
        }
    }

    //Alterar os dados de um livro
    public void alterar(Livro livro){
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ? WHERE idLivro = ?";
        try (Connection conn = conexao.getConexaoDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            //Define os valores dos parâmetros
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setInt(3, livro.getAno());
            pst.setInt(4, livro.getId());
            //Executa o comando SQL
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Alteracao ok para id = " + livro.getId());
            } else {
                System.out.println("Nao ha registro para alterar com id = " + livro.getId());
            }
        } catch (Exception e) {
            System.out.println("Falha na alteracao: " + e.getMessage());
        }
    }
}
