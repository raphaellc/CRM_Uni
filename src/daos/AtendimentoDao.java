package daos;

import dtos.AtendimentoDto;
import modelos.Atendimento;

import java.sql.*;
import java.time.LocalDate;
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

            String sql = "INSERT INTO crmuni.atendimento (id_pessoa, id_pessoa_responsavel, dt_abertura, dt_resolucao, desc_problema, id_categoria, id_prioridade) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, atendimentoDto.getIdAtendimento());
            preparedStatement.setInt(2, atendimentoDto.getIdResponsavel());
            preparedStatement.setDate(3, Date.valueOf(atendimentoDto.getDtAbertura()));
            preparedStatement.setDate(4, Date.valueOf(atendimentoDto.getDtResolucao()));
            preparedStatement.setString(5, atendimentoDto.getDescProblema());
            preparedStatement.setInt(6, atendimentoDto.getIdCategoria());
            preparedStatement.setInt(7, atendimentoDto.getPrioridadeCaso());

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

    public boolean atualizarAtendimento(AtendimentoDto atendimentoDto){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.con.conectar();

            String sql = "UPDATE crmuni.atendimento SET status_atualizacao = ?, dt_atualizacao = ?, desc_atualizacao = ? WHERE id_atendimento = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, atendimentoDto.getStatusAtualizacao());
            preparedStatement.setDate(2, Date.valueOf(atendimentoDto.getDtAtualizacao()));
            preparedStatement.setString(3, atendimentoDto.getDescAtualizacao());
            preparedStatement.setInt(4, atendimentoDto.getIdAtendimento());

            if (preparedStatement.executeUpdate() != 0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Falha ao atualizar. Mensagem de erro: " + e.getMessage());
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
                System.out.println("Falha ao atualizar. Mensagem de erro: " + e.getMessage());
            }
        }
        return false;
    }
    public boolean removerAtendimento(int idAtendimento){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.con.conectar();

            String sql =  "DELETE FROM crmuni.atendimento WHERE id_atendimento = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idAtendimento);



            return preparedStatement.executeUpdate() != 0;


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
    public List<AtendimentoDto> listarAtendimento(){
        List<AtendimentoDto> atendimentos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.con.conectar(); // Obtém a conexão usando a classe Conexao

            String sql = "SELECT * FROM crmuni.atendimento";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AtendimentoDto atendimentoDto = new AtendimentoDto();
                atendimentoDto.setIdAtendimento(resultSet.getInt("id_pessoa"));
                atendimentoDto.setIdResponsavel(resultSet.getInt("id_pessoa_responsavel"));
                atendimentoDto.setDtAbertura(resultSet.getDate("dt_abertura").toLocalDate());
                atendimentoDto.setDtResolucao(resultSet.getDate("dt_resolucao").toLocalDate());
                atendimentoDto.setDescProblema(resultSet.getString("desc_problema"));
                atendimentoDto.setIdCategoria(resultSet.getInt("id_categoria"));
                atendimentoDto.setPrioridadeCaso(resultSet.getInt("id_prioridade"));
                atendimentoDto.setStatusAtualizacao(resultSet.getString("status_atualizacao"));
                if (resultSet.getDate("dt_atualizacao") != null) {
                    atendimentoDto.setDtAtualizacao(resultSet.getDate("dt_atualizacao").toLocalDate());
                }
                atendimentoDto.setDescAtualizacao(resultSet.getString("desc_atualizacao"));

                atendimentos.add(atendimentoDto);

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

        // Print dos atendimentos na tela
        for (AtendimentoDto atendimentoDto : atendimentos) {
            System.out.println(atendimentoDto);
        }

        return atendimentos;
    }


    public static void main(String[] args) {
        /// Testando a conexão com o banco de dados
        Connection conexao = AtendimentoConexao.conectar();

        // Criando uma instância de AtendimentoConexao
        AtendimentoConexao atendimentoConexao = new AtendimentoConexao();

        // Criando uma instância de AtendimentoDao, passando a instância de AtendimentoConexao
        AtendimentoDao atendimentoDao = new AtendimentoDao(atendimentoConexao);

        // Adicionando um novo atendimento
//        AtendimentoDto atendimentoDto = new AtendimentoDto();
//        atendimentoDto.setIdAtendimento(8);
//        atendimentoDto.setIdResponsavel(9);
//        atendimentoDto.setDtAbertura(LocalDate.now());
//        atendimentoDto.setDtResolucao(LocalDate.now().plusDays(1));
//        atendimentoDto.setDescProblema("Mais um teste");
//        atendimentoDto.setIdCategoria(5);
//        atendimentoDto.setPrioridadeCaso(2);
//
//        boolean sucessoAdicao = atendimentoDao.adicionarAtendimento(atendimentoDto);
//        if (sucessoAdicao) {
//            System.out.println("Atendimento adicionado com sucesso!");
//        } else {
//            System.out.println("Falha ao adicionar o atendimento.");
//        }
//
//        List<AtendimentoDto> listaAtendimentos = atendimentoDao.listarAtendimento();

        // Atribuindo status a um atendimento
        AtendimentoDto atendimentoAtualizado = new AtendimentoDto();
        atendimentoAtualizado.setIdAtendimento(5); // Substituir pelo ID que deseja atribuir um status
        atendimentoAtualizado.setStatusAtualizacao("Status Teste");
        atendimentoAtualizado.setDtAtualizacao(LocalDate.now());
        atendimentoAtualizado.setDescAtualizacao("Descrição teste");

        boolean atualizacaoAtendimento = atendimentoDao.atualizarAtendimento(atendimentoAtualizado);
        if (atualizacaoAtendimento) {
            System.out.println("Atendimento atualizado!");
        } else {
            System.out.println("Falha ao atualizar!.");
        }
        AtendimentoConexao.fecharConexao(conexao);
    }

    }

