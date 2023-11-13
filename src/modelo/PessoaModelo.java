package modelo;

import static dao.PessoaQuery.CONSULTAR_TODAS_PESSOAS;
import static dao.PessoaQuery.CRIAR_ENDERECO;
import static dao.PessoaQuery.CRIAR_PESSOA;
import static dao.PessoaQuery.DELETAR_PESSOA_ID;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static util.DateUtils.transformDateTime;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dao.PessoaDAO;
import dao.conexao.ConexaoMySQL;
import dao.conexao.ConexaoStrategy;
import dto.EnderecoDTO;
import dto.PessoaDTO;
import util.DateUtils;
import util.ValorUtil;

public class PessoaModelo{
    private PessoaDAO pessoaDAO;
    public PessoaModelo(){
        pessoaDAO = new PessoaDAO();
    }

    public boolean cadastrar(final PessoaDTO dados){

        if(Objects.nonNull(dados.getEndereco())){
            EnderecoDTO endereco = dados.getEndereco();

            if(ValorUtil.isEmptyString(endereco.getEstado())){
                return false;
            };

            if(ValorUtil.isEmptyString(endereco.getCidade())){
                return false;
            };
        }

        boolean existe = pessoaDAO.existeEmail(dados.getEmail());

        if(existe){
            return false;
        }

        PessoaDTO retornoConsultar = pessoaDAO.criarContato(dados);

        if(Objects.isNull(retornoConsultar)){
            return false;
        }

        return true;
    }

    public List<PessoaDTO> consultarTodos(){
        return pessoaDAO.consultarTodos();
    }

    public PessoaDTO consultarID(final Long ID){
        return pessoaDAO.consultarID(ID);
    }

    public void deletar(final Long ID){
        pessoaDAO.deletar(ID);
    }
}
