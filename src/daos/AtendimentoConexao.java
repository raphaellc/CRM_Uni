package daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AtendimentoConexao {
    //Implementar a conexão com o banco de dados.
    //Dados abaixo devem ser configurados de acordo com cada maquina/banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/crmuni";
    private static final String USUARIO = "root";
    private static final String SENHA = "arthur";

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(("Conexão Realizada!"));
            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão Fechada!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão: " + e.getMessage(), e);
        }
    }

}


