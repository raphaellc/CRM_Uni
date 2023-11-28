package modelos;

import daos.AtendimentoDao;
import daos.AtendimentoConexao;
import dtos.AtendimentoDto;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {
    private List<AtendimentoDto> atendimentos;
    private AtendimentoDao atendimentoDao;
    private AtendimentoConexao conexao;

    public Atendimento() {
        conexao = new AtendimentoConexao();
        atendimentoDao = new AtendimentoDao(conexao);
        atendimentos = new ArrayList<>();
    }

    public boolean adicionarAtendimento(AtendimentoDto atendimentoDto) {
        atendimentos.add(atendimentoDto);
        return atendimentoDao.adicionarAtendimento(atendimentoDto);
    }

    public List<AtendimentoDto> listarAtendimentos() {
        return atendimentoDao.listarAtendimentos();
    }
}