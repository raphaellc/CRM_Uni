package daos;

import dtos.AtendimentoDto;
import modelos.Atendimento;

import java.util.ArrayList;
import java.util.List;

public class AtendimentoDao {
    public boolean adicionarAtendimento(Atendimento){
        return true; // Implementar a adição dos atendimentos no banco de dados.
    }
    public boolean alterarAtendimento(Atendimento){
        return true; // Implementar a alteração dos atendimentos no banco de dados.
    }
    public boolean removerAtendimento(Atendimento){
        return true; //Implementar a remoção de atendimentos no banco de dados.
    }
    public List<AtendimentoDto> listarAtendimento(){
        List<AtendimentoDto> atendimentos = new ArrayList<>();
        return atendimentos; //Implementar a listagem dos atendimentos no banco de dados.
    }
}