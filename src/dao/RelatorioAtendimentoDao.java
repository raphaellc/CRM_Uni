package src.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class RelatorioAtendimentoDao {

    public static void main(String[] args) {
        conectar();
        System.out.println("Hello");
    }

    public static Connection conectar() {
        Connection con;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = System.getenv("url");
        String username = System.getenv("username");
        String password = System.getenv("password");
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

