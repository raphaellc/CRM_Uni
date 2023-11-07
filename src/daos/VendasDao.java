package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dtos.VendasDto;
import java.util.Date;

public class VendasDao {
	private Connection con;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/crmuni"; //###############------------------ APÓS A ULTIMA "/" COLOCAR O NOME DO BANCO DE DADOS ------------------###############
	private String user = "root"; //###############------------------ COLOCAR AQUI O USUARIO ------------------###############
	private String password = "!"; //###############------------------ COLOCAR AQUI A SENHA DEFINIDA AO CRIAR O DB ------------------###############
	
	public Connection conectar() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password); //RESPONSÁVEL POR FAZER A CONEXAO COM O DB
			System.out.println("Conexao estabelecida");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public boolean adicionarVendas(VendasDto vendas) {
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {        	
            connection = conectar(); // Obtém a conexão usando a classe Conexao

            String sql = "INSERT INTO vendas VALUES (?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, vendas.getId_venda());
            ps.setFloat(2, vendas.getValor_venda());
            ps.setString(3, vendas.getDt_venda());
            ps.setString(4, vendas.getStatus()); 
                   
            // Definindo os atributos restantes da mesma maneira

           if (ps.executeUpdate() != 0){
               return true;
           	}

        } catch (SQLException e) {
              	e.printStackTrace();    } 
        
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

	
	public VendasDto buscarVenda(int id_venda) {
		Connection connection = null;
        
       	connection = conectar(); // Obtém a conexão usando a classe Conexao
       	
       	String sql = "SELECT id_venda, valor_venda, dt_venda, status FROM vendas WHERE id_venda=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setFloat(1, id_venda);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				VendasDto vendas = new VendasDto();
				vendas.setId_venda(rs.getInt(1));
				vendas.setValor_venda(rs.getFloat(2));
				vendas.setDt_venda(rs.getString(3));
				vendas.setStatus(rs.getString(4));
				
				return vendas;
							}
	
			}          
		
		catch (SQLException e) {
            e.printStackTrace();
								}
		
			return null;
		}
		
		
	public boolean atualizarVendaStatus(float valor_venda, int id_venda) {
		
		Connection connection = null;
        
       	connection = conectar(); // Obtém a conexão usando a classe Conexao
       	
       	String sql = "UPDATE vendas set status=? WHERE id_venda=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setFloat(1, valor_venda);
			ps.setInt(2, id_venda);			
		
			return ps.executeUpdate()>0;
			}          
		
		catch (SQLException e) {
            e.printStackTrace();
								}
		
			return false;
		}
       	
	
	
	public boolean deletarVendas(int id_venda) {
		
		Connection connection = null;
        
       	connection = conectar(); // Obtém a conexão usando a classe Conexao
		
		String sql = "DELETE FROM vendas WHERE id_venda=?";
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setInt(1, id_venda);
		
			return ps.executeUpdate()>0;
				}          
		catch (SQLException e) {
            e.printStackTrace();
								}
		
			return false;
		}
		
		


public List<VendasDto> listarVendas() {
			
	List<VendasDto> list= null;
	
	try {
				list = new ArrayList<VendasDto>();
				String sql = "SELECT id_venda, valor_venda, status dt_venda FROM vendas";
				Connection connection = null;
			   	connection = conectar(); // Obtém a conexão usando a classe Conexao
		
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					VendasDto vendas = new VendasDto();
					vendas.setId_venda(rs.getInt(1));
					vendas.setValor_venda(rs.getFloat(2));
					vendas.setDt_venda(rs.getString(3));
					vendas.setStatus(rs.getString(4));
					
					list.add(vendas);
				}
		}  catch (SQLException e) {
				e.printStackTrace();
		}
	
		return list;
	}

}






