package dao.conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ConexaoStrategy {

    Connection abrir() throws SQLException;

    void fechar();

    void fechar(ResultSet... resultado);

    StatusConexao getStatus();

    String getNomeBanco();
}
