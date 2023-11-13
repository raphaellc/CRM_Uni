package daos;

import dtos.ContatoDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {
    private daos.Conexao con;

    public ContatoDao(Conexao conexao) {
        this.con = conexao;
    }

    public ContatoDao() {
        this.con = new daos.Conexao();
    }

    public boolean adicionarContato(ContatoDto contato) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.con.conectar();

            String sql = "INSERT INTO crmem.pessoas (nome, dt_nasc, celular, email, id_setor, ocupacao, id_origem, dt_hr_origem, id_tipo_pessoa) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setDate(2, Date.valueOf(contato.getDt_nasc()));
            preparedStatement.setString(3, contato.getCelular());
            preparedStatement.setString(4, contato.getEmail());
            preparedStatement.setInt(5, contato.getId_setor());
            preparedStatement.setString(6, contato.getOcupacao());
            preparedStatement.setInt(7, contato.getId_origem());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(contato.getDt_hr_origem()));
            preparedStatement.setInt(9, contato.getId_tipo_pessoa());

            // Definindo os atributos restantes da mesma maneira

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public List<ContatoDto> listarContatos() {
        List<ContatoDto> contatos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Conexao.conectar();

            String sql = "SELECT id_pessoas, nome, dt_nasc, celular, email, id_setor, ocupacao, id_origem, dt_hr_origem, id_tipo_pessoa FROM crmem.pessoas";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ContatoDto contato = new ContatoDto();
                contato.setId_pessoa(resultSet.getInt("id_pessoas"));
                contato.setNome(resultSet.getString("nome"));
                contato.setDt_nasc(resultSet.getDate("dt_nasc").toLocalDate());
                contato.setCelular(resultSet.getString("celular"));
                contato.setEmail(resultSet.getString("email"));
                contato.setId_setor(resultSet.getInt("id_setor"));
                contato.setOcupacao(resultSet.getString("ocupacao"));
                contato.setId_origem(resultSet.getInt("id_origem"));
                contato.setDt_hr_origem(resultSet.getTimestamp("dt_hr_origem").toLocalDateTime());
                contato.setId_tipo_pessoa(resultSet.getInt("id_tipo_pessoa"));
                contatos.add(contato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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

        return contatos;
    }
}
