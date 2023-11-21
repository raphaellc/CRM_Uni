package src.dao;

import src.dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class AnaliseVendasDao {
    private Conexao con;

    public AnaliseVendasDao(Conexao con) {
        this.con = con;
    }

    public boolean identificaProdutoMaiorValor(AnaliseVendasDto analiseVendasDto) {


        try {
            connection = this.con.conectar();

            String sql = "INSERT INTO analiseVendas VALUES (?, ?, ?, ?, ?)"; //teste
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, analiseVendasDto.getId_venda());
            ps.setInt(2, analiseVendasDto.getId_produto());
            ps.setDouble(3, analiseVendasDto.getValorProduto());


        } catch{

        }
    }
}
