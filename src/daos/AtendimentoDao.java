package daos;

import dtos.AtendimentoDto;
import dtos.ProgressoAtendimentoDto;
import dtos.StatusAtendimentoDto;
import modelos.Atendimento;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        PreparedStatement preparedStatementAtendimento = null;
        PreparedStatement preparedStatementStatus = null;
        PreparedStatement preparedStatementProgresso = null;

        try {
            connection = this.con.conectar(); // Obtém a conexão usando a classe Conexao

            // Inserir na tabela atendimento
            String sqlAtendimento = "INSERT INTO crmuni.atendimento (id_pessoa, id_pessoa_responsavel, dt_abertura, desc_problema, id_categoria, id_prioridade) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatementAtendimento = connection.prepareStatement(sqlAtendimento, Statement.RETURN_GENERATED_KEYS);

            preparedStatementAtendimento.setInt(1, atendimentoDto.getIdPessoa());
            preparedStatementAtendimento.setInt(2, atendimentoDto.getIdResponsavel());
            preparedStatementAtendimento.setDate(3, Date.valueOf(atendimentoDto.getDtAbertura()));
            preparedStatementAtendimento.setString(4, atendimentoDto.getDescProblema());
            preparedStatementAtendimento.setInt(5, atendimentoDto.getIdCategoria());
            preparedStatementAtendimento.setInt(6, atendimentoDto.getPrioridadeCaso());

            // Executar a inserção na tabela atendimento
            if (preparedStatementAtendimento.executeUpdate() != 0) {
                // Recuperar o ID do atendimento recém-criado
                ResultSet generatedKeys = preparedStatementAtendimento.getGeneratedKeys();
                int idAtendimento = -1;
                if (generatedKeys.next()) {
                    idAtendimento = generatedKeys.getInt(1);
                }

                // Inserir na tabela status_atendimento
                String sqlStatus = "INSERT INTO crmuni.status_atendimento (descricao) VALUES (?)";

                preparedStatementStatus = connection.prepareStatement(sqlStatus, Statement.RETURN_GENERATED_KEYS);
                preparedStatementStatus.setString(1, "Atendimento criado");

                // Executar a inserção na tabela status_atendimento
                if (preparedStatementStatus.executeUpdate() != 0) {
                    // Recuperar o ID do status_atendimento recém-criado
                    ResultSet generatedStatusKeys = preparedStatementStatus.getGeneratedKeys();
                    int idStatusAtendimento = -1;
                    if (generatedStatusKeys.next()) {
                        idStatusAtendimento = generatedStatusKeys.getInt(1);

                        // Inserir na tabela progresso_atendimento
                        String sqlProgresso = "INSERT INTO crmuni.progresso_atendimento (descricao, dt_atualizacao, id_atendimento, id_status_atendimento) " +
                                "VALUES (?, ?, ?, ?)";

                        preparedStatementProgresso = connection.prepareStatement(sqlProgresso);
                        preparedStatementProgresso.setString(1, "Atendimento Recém Criado");
                        preparedStatementProgresso.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
                        preparedStatementProgresso.setInt(3, idAtendimento);
                        preparedStatementProgresso.setInt(4, idStatusAtendimento);

                        // Executar a inserção na tabela progresso_atendimento
                        preparedStatementProgresso.executeUpdate();

                        return true;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatementAtendimento != null) {
                    preparedStatementAtendimento.close();
                }
                if (preparedStatementStatus != null) {
                    preparedStatementStatus.close();
                }
                if (preparedStatementProgresso != null) {
                    preparedStatementProgresso.close();
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

    public int atualizarStatusAtendimento(StatusAtendimentoDto statusAtendimentoDto) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            connection = this.con.conectar();
            String sql = "INSERT INTO crmuni.status_atendimento (descricao) VALUES (?)";

            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, statusAtendimentoDto.getDescStatusAtendimento());

            if (preparedStatement.executeUpdate() != 0) {
                // Recuperar o ID gerado automaticamente
                generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idStatusAtendimento = generatedKeys.getInt(1);
                    return idStatusAtendimento;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Falha ao atualizar. Mensagem de erro: " + e.getMessage());
        } finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
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
        return -1; // Retorna -1 em caso de falha
    }

    public boolean atualizarProgAtendimento(ProgressoAtendimentoDto progressoAtendimentoDto){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.con.conectar();

            String sql = "INSERT INTO crmuni.progresso_atendimento (descricao, dt_atualizacao, id_atendimento, id_status_atendimento) " +
                    "VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, progressoAtendimentoDto.getDescAtualizacao());
            preparedStatement.setDate(2, Date.valueOf(progressoAtendimentoDto.getDataAtualizacao()));
            preparedStatement.setInt(3, progressoAtendimentoDto.getIdCasoAtendimento());
            preparedStatement.setInt(4, progressoAtendimentoDto.getIdStatusCasoAtendimento());

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
    private void atualizarDtResolucao(int idAtendimento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.con.conectar();

            String sql = "UPDATE crmuni.atendimento SET dt_resolucao = ? WHERE id_atendimento = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(2, idAtendimento);

            preparedStatement.executeUpdate();
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
    }

    public boolean fecharAtendimento(int idAtendimento){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.con.conectar();


            AtendimentoDto atendimentoAntesDeFechar = buscarAtendimentoPorId(idAtendimento);

            if (atendimentoAntesDeFechar != null) {

                AtendimentoDto atendimentoFechado = new AtendimentoDto();
                atendimentoFechado.setIdAtendimento(idAtendimento);
                atendimentoFechado.setStatusAtualizacao("Fechado");
                atendimentoFechado.setDtAtualizacao(LocalDate.now());
                atendimentoFechado.setDtResolucao(LocalDate.now());
                atendimentoFechado.setDescAtualizacao("Atendimento fechado/Concluído");
                boolean atualizacaoAtendimento = atualizarAtendimento(atendimentoFechado);

                StatusAtendimentoDto statusAtendimentoDto = new StatusAtendimentoDto();
                statusAtendimentoDto.setDesc("Fechado");
                int novoStatusAtendimento = atualizarStatusAtendimento(statusAtendimentoDto);

                ProgressoAtendimentoDto progressoAtendimentoDto = new ProgressoAtendimentoDto();
                progressoAtendimentoDto.setIdCasoAtendimento(idAtendimento);
                progressoAtendimentoDto.setDescAtualizacao("Atendimento fechado/concluído");
                progressoAtendimentoDto.setDataAtualizacao(LocalDate.now());
                progressoAtendimentoDto.setIdStatusCasoAtendimento(novoStatusAtendimento);

                boolean novoProgressoAtendimento = atualizarProgAtendimento(progressoAtendimentoDto);






                if (atualizacaoAtendimento) {
                    atualizarDtResolucao(idAtendimento);
                    return true;
                } else {
                    System.out.println("Falha ao atualizar o atendimento antes de fechar.");
                }
            } else {
                System.out.println("Atendimento não encontrado para o ID: " + idAtendimento);
            }

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


    public List<AtendimentoDto> listarAtendimentos(){
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
                atendimentoDto.setIdAtendimento(resultSet.getInt("id_atendimento"));
                atendimentoDto.setIdResponsavel(resultSet.getInt("id_pessoa_responsavel"));
                atendimentoDto.setDtAbertura(resultSet.getDate("dt_abertura").toLocalDate());
                java.sql.Date dtResolucao = resultSet.getDate("dt_resolucao");
                atendimentoDto.setDtResolucao(dtResolucao != null ? dtResolucao.toLocalDate() : null);
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

    public AtendimentoDto buscarAtendimentoPorId(int idAtendimento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AtendimentoDto atendimentoDto = null;

        try {
            connection = this.con.conectar();


            String sql = "SELECT * FROM crmuni.atendimento WHERE id_atendimento = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAtendimento);

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                atendimentoDto = new AtendimentoDto();
                atendimentoDto.setIdAtendimento(resultSet.getInt("id_atendimento"));
                atendimentoDto.setIdResponsavel(resultSet.getInt("id_pessoa_responsavel"));
                atendimentoDto.setIdPessoa(resultSet.getInt("id_pessoa"));
                atendimentoDto.setDtAbertura(resultSet.getDate("dt_abertura").toLocalDate());
                atendimentoDto.setDescProblema(resultSet.getString("desc_problema"));
                atendimentoDto.setIdCategoria(resultSet.getInt("id_categoria"));
                atendimentoDto.setPrioridadeCaso(resultSet.getInt("id_prioridade"));
                atendimentoDto.setStatusAtualizacao(resultSet.getString("status_atualizacao"));
                java.sql.Date dtResolucao = resultSet.getDate("dt_resolucao");
                atendimentoDto.setDtResolucao(dtResolucao != null ? dtResolucao.toLocalDate() : null);

                if (resultSet.getDate("dt_atualizacao") != null) {
                    atendimentoDto.setDtAtualizacao(resultSet.getDate("dt_atualizacao").toLocalDate());
                }
                atendimentoDto.setDescAtualizacao(resultSet.getString("desc_atualizacao"));
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


        if (atendimentoDto != null) {

            System.out.println(atendimentoDto);
        } else {
            System.out.println("Atendimento não encontrado para o ID: " + idAtendimento);
        }

        return atendimentoDto;
    }

    public String listarProgressoPorId(int idAtendimento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder dados = new StringBuilder();

        try {
            connection = this.con.conectar();

            String sql = "SELECT descricao, dt_atualizacao FROM crmuni.progresso_atendimento WHERE id_atendimento = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAtendimento);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                LocalDate dtAtualizacao = resultSet.getDate("dt_atualizacao").toLocalDate();

                dados.append("Data de Atualização: ").append(dtAtualizacao).append(", Descrição Da Atualização: ").append(descricao).append("\n");

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

        return dados.toString();
    }
    public int[] listarIdStatusPorIdAtendimento(int idAtendimento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> idStatusList = new ArrayList<>();

        try {
            connection = this.con.conectar();

            String sql = "SELECT id_status_atendimento FROM crmuni.progresso_atendimento WHERE id_atendimento = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAtendimento);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idStatus = resultSet.getInt("id_status_atendimento");
                idStatusList.add(idStatus);
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


        int[] idStatusArray = idStatusList.stream().mapToInt(Integer::intValue).toArray();
        return idStatusArray;
    }

    public String[] listarDescricaoStatusPorIds(int[] idStatusArray) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> descricaoList = new ArrayList<>();

        try {
            connection = this.con.conectar();

            // Construindo a cláusula IN para evitar SQL Injection
            String inClause = Arrays.stream(idStatusArray).mapToObj(String::valueOf).collect(Collectors.joining(", ", "(", ")"));

            String sql = "SELECT descricao FROM crmuni.status_atendimento WHERE id_status_atendimento IN " + inClause;
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            // Adicionado um contador para representar a posição do status
            int index = 1;
            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");

                // Criando a string formatada com base no índice
                descricaoList.add("Status " + index + ": " + descricao);

                // Incrementando o índice para o próximo status
                index++;
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

        // Convertendo a lista para um array de strings
        String[] descricaoArray = descricaoList.toArray(new String[0]);
        return descricaoArray;
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
//        List<AtendimentoDto> listaAtendimentos = atendimentoDao.listarAtendimentos();

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

