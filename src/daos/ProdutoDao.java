package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dtos.ProdutoDto;

public class ProdutoDao {
	private Connection con;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/crmuni"; //###############------------------ APÓS A ULTIMA "/" COLOCAR O NOME DO BANCO DE DADOS ------------------###############
	private String user = "root"; //###############------------------ COLOCAR AQUI O USUARIO ------------------###############
	private String password = "Edm0911!"; //###############------------------ COLOCAR AQUI A SENHA DEFINIDA AO CRIAR O DB ------------------###############
	
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
	
	public boolean adicionarProduto(ProdutoDto produto) {
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {        	
            connection = conectar(); // Obtém a conexão usando a classe Conexao

            String sql = "INSERT INTO produtos VALUES (?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, produto.getId_produto());
            ps.setInt(2, produto.getQtd_produto());
            ps.setDouble(3, produto.getValor_unitario());
            ps.setString(4, produto.getDescricao_produto()); 
                   
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

	
	public ProdutoDto buscarProduto(int id_produto) {
		Connection connection = null;
        
       	connection = conectar(); // Obtém a conexão usando a classe Conexao
       	
       	String sql = "SELECT idProdutos, quantidadeProdutos, valorUnitario, descricaoProduto FROM produtos WHERE idProduto=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setInt(1, id_produto);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ProdutoDto produto = new ProdutoDto();
				produto.setId_produto(rs.getInt(1));
				produto.setQtd_produto(rs.getInt(2));
				produto.setValor_unitario(rs.getDouble(3));
				produto.setDescricao_produto(rs.getString(4));
				
				return produto;
							}
	
			}          
		
		catch (SQLException e) {
            e.printStackTrace();
								}
		
			return null;
		}
		
		
	public boolean atualizarProduto(double valor_unitario, int id_produto) {
		
		Connection connection = null;
        
       	connection = conectar(); // Obtém a conexão usando a classe Conexao
       	
       	String sql = "UPDATE produtos set valorUnitario=? WHERE idProduto=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setDouble(1, valor_unitario);
			ps.setInt(2, id_produto);			
		
			return ps.executeUpdate()>0;
			}          
		
		catch (SQLException e) {
            e.printStackTrace();
								}
		
			return false;
		}
       	
	
	
	public boolean deletarProduto(int id_produto) {
		
		Connection connection = null;
        
       	connection = conectar(); // Obtém a conexão usando a classe Conexao
		
		String sql = "DELETE FROM produtos WHERE idProduto=?";
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setInt(1, id_produto);
		
			return ps.executeUpdate()>0;
				}          
		catch (SQLException e) {
            e.printStackTrace();
								}
		
			return false;
		}
		
		


public List<ProdutoDto> listarProdutos() {
			
	List<ProdutoDto> list= null;
	
	try {
				list = new ArrayList<ProdutoDto>();
				String sql = "SELECT idProduto, quantidadeProdutos, valorUnitario, descricaoProduto FROM produtos";
				Connection connection = null;
			   	connection = conectar(); // Obtém a conexão usando a classe Conexao
		
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					ProdutoDto produto = new ProdutoDto();
					produto.setId_produto(rs.getInt(1));
					produto.setQtd_produto(rs.getInt(2));
					produto.setValor_unitario(rs.getDouble(3));
					produto.setDescricao_produto(rs.getString(4));
					
					list.add(produto);
				}
		}  catch (SQLException e) {
				e.printStackTrace();
		}
	
		return list;
	}

}


