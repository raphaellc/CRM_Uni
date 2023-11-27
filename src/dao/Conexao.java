package src.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import src.dto.AnaliseVendasDto;

public class Conexao {
    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = System.getenv("url");
    private static final String username = System.getenv("username");
    private static final String password = System.getenv("password");

    public Connection conectar() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Conexao estabelecida");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}