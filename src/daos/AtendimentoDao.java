package daos;

import dtos.*;
import modelos.Atendimento;
import daos.AtendimentoConexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDao {

    private daos.AtendimentoConexao con;

    public AtendimentoDao(AtendimentoConexao atendimentoConexao) {
        this.con = atendimentoConexao;
    }

    public AtendimentoDao(){
        this.con = new daos.AtendimentoConexao();
    }

    public boolean adicionarAtendimento(AtendimentoDto atendimentoDto) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.con.conectar(); // Obtém a conexão usando a classe Conexao

            String sql = "INSERT INTO crmem.pessoas (id_pessoa, id_pessoa_responsavel, dt_abertura, dt_resolucao, desc_problema, id_categoria, id_prioridadege) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, atendimentoDto.getIdAtendimento());
            preparedStatement.setInt(2, atendimentoDto.getIdResponsavel());
            preparedStatement.setDate(3, Date.valueOf(atendimentoDto.getDtAbertura()));
            preparedStatement.setDate(4, Date.valueOf(atendimentoDto.getDtResolucao()));
            preparedStatement.setString(5, atendimentoDto.getDescProblema());
            preparedStatement.setInt(6, atendimentoDto.getIdCategoria());
            preparedStatement.setString(7, atendimentoDto.getPrioridadeCaso());

            // Definindo os atributos restantes da mesma maneira

            if (preparedStatement.executeUpdate() != 0){
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

    public boolean alterarAtendimento(Atendimento atendimento){
        return true; // Implementar a alteração dos atendimentos no banco de dados.
    }
    public boolean removerAtendimento(Atendimento atendimento){
        return true; //Implementar a remoção de atendimentos no banco de dados.
    }
    public List<AtendimentoDto> listarAtendimento(){
        List<AtendimentoDto> atendimentos = new ArrayList<>();
        return atendimentos; //Implementar a listagem dos atendimentos no banco de dados.
    }


    public static void main(String[] args) {
        //testando a conexão com o banco de dados
        Connection conexao = AtendimentoConexao.conectar();
        AtendimentoConexao.fecharConexao(conexao);
    }
}

