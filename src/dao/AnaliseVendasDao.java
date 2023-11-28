package src.dao;

import src.dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnaliseVendasDao {

/**
    public void boolean identificaProdutoMaiorValor(AnaliseVendasDto analiseVendasDto) {

         try {
         connection = this.con.conectar();
         String sql = "INSERT INTO analiseVendas VALUES (?, ?, ?, ?, ?)"; //teste
         PreparedStatement ps = connection.prepareStatement(sql);

         ps.setInt(1, analiseVendasDto.getId_venda());
         ps.setInt(2, analiseVendasDto.getId_produto());
         ps.setDouble(3, analiseVendasDto.getValorProduto());

         } catch{

         }
        System.out.println("Aqui");
    }**/

/**
    public AnaliseVendasDto listarVendas() {
        List<AnaliseVendasDto> listarVendas = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            Connection conn = Conexao.conectar();

            String sql = "SELECT id_venda, valor_venda, data_venda, status, quantidade_produtos, id_vendedor FROM vendas WHERE id_venda = ?";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AnaliseVendasDto vendas = new AnaliseVendasDto();
                vendas.setId_venda(resultSet.getInt(1));
                vendas.setValor_venda(resultSet.getFloat(2));
                vendas.setData_venda(resultSet.getDate(3));
                vendas.setStatus(resultSet.getString(4));
                vendas.setQuantidade_produtos(resultSet.getInt(5));
                vendas.setId_vendedor(resultSet.getInt(6));

                return vendas;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } return null;
 **/

    /**
    public void buscarVendas(int id_venda) {

        Connection conexao = Conexao.conectar();

        String sql = "SELECT id_venda, valor_venda, dt_venda, status FROM vendas WHERE id_venda = ?"

    } **/

}