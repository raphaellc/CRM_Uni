package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = System.getenv("URL");
    private static final String USUARIO = System.getenv("USUARIO");
    private static final String SENHA = System.getenv("SENHA");

    public static Connection conectar() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}