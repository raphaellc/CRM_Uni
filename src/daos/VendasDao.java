package daos;

import java.sql.Connection;
import java.sql.DriverManager;

public class VendasDao {
	private Connection con;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/"; //###############------------------ APÓS A ULTIMA "/" COLOCAR O NOME DO BANCO DE DADOS ------------------###############
	private String user = ""; //###############------------------ COLOCAR AQUI O USUARIO ------------------###############
	private String password = ""; //###############------------------ COLOCAR AQUI A SENHA DEFINIDA AO CRIAR O DB ------------------###############
	
	public Connection conectar() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password); //RESPONSÁVEL POR FAZER A CONEXAO COM O DB
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void criar() {}
	public void buscar() {}
	public void atualizar() {}
	public void deletar() {}
}
