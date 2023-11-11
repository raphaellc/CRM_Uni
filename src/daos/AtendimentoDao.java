package daos;

import dtos.AtendimentoDto;
import modelos.Atendimento;
import daos.AtendimentoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDao {

    public boolean adicionarAtendimento(Atendimento atendimento){
        return true; // Implementar a adição dos atendimentos no banco de dados.
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

