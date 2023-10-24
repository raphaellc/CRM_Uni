package dao.conexao;

import static dao.conexao.StatusConexao.ABERTA;
import static dao.conexao.StatusConexao.FECHADA;
import static java.lang.String.format;
import static java.util.Objects.nonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ConexaoMySQL implements ConexaoStrategy {

    private Connection connection;
    private StatusConexao status;

    private String username;
    private String password;
    private String url;

    public ConexaoMySQL() {
        this.connection = null;
        this.status = FECHADA;

        this.username = System.getenv("DB_USERNAME");
        this.password = System.getenv("DB_PASSWORD");
        this.url = format("jdbc:mysql://%s:3306/%s", System.getenv("DB_SERVER"),
            System.getenv("DB_NAME"));
    }

    @Override
    public Connection abrir() throws SQLException {
        if (ABERTA == status) {
            return this.connection;
        }

        this.connection = DriverManager.getConnection(url, username, password);
        this.status = ABERTA;
        return this.connection;
    }

    @Override
    public void fechar() {
        if (FECHADA == status) {
            return;
        }

        try {
            this.connection.close();
            this.status = FECHADA;
        } catch (final SQLException exception) {
            System.out.println("[ERRO] Problema encotrado para fechar resultado da conexão com o banco");
            exception.printStackTrace();
        }
    }

    @Override
    public void fechar(final ResultSet... resultados) {
        if (nonNull(resultados)) {
            try {

                for (ResultSet resultado: resultados) {
                    if (nonNull(resultado)){
                        resultado.close();
                    }
                }

            } catch (final SQLException exception) {
                System.out.println("[ERRO] Problema encotrado para fechar resultado da conexão com o banco");
                exception.printStackTrace();
            }
        }
    }

    @Override
    public StatusConexao getStatus() {
        return this.status;
    }

    @Override
    public String getNomeBanco() {
        return "MySQL";
    }
}
