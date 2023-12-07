

package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dto.StatusPessoaDTO;

public class StatusPessoaDAO {
    private final Connection connection;

    public StatusPessoaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<StatusPessoaDTO> getAllStatusPessoa() {
        List<StatusPessoaDTO> statusPessoas = new ArrayList<StatusPessoaDTO>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM status_pessoa");
            while (resultSet.next()) {
                int idStatusPessoa = resultSet.getInt("id_status_pessoa");
                String descricao = resultSet.getString("descricao");
                StatusPessoaDTO statusPessoa = new StatusPessoaDTO(statusPessoas, descricao);
                statusPessoas.add(statusPessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusPessoas;
    }

    public StatusPessoaDTO getStatusPessoaById(int idStatusPessoa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM status_pessoa WHERE id_status_pessoa = ?");
            preparedStatement.setInt(1, idStatusPessoa);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                return new IdStatusPessoa();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addStatusPessoa(StatusPessoaDTO statusPessoa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO status_pessoa (descricao) VALUES (?)");
            preparedStatement.setString(1, statusPessoa.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusPessoa(@org.jetbrains.annotations.NotNull StatusPessoaDTO statusPessoa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE status_pessoa SET descricao = ? WHERE id_status_pessoa = ?");
            preparedStatement.setString(1, statusPessoa.getDescricao());
            preparedStatement.setInt(2, statusPessoa.getIdStatusPessoa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStatusPessoa(int idStatusPessoa) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM status_pessoa WHERE id_status_pessoa = ?");
            preparedStatement.setInt(1, idStatusPessoa);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}