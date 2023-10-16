package dao;

import static dao.PessoaQuery.CONSULTAR_TODAS_PESSOAS;
import static dao.PessoaQuery.CRIAR_ENDERECO;
import static dao.PessoaQuery.CRIAR_PESSOA;
import static dao.PessoaQuery.DELETAR_PESSOA_ID;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
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

import dao.conexao.ConexaoMySQL;
import dao.conexao.ConexaoStrategy;
import dto.EnderecoDTO;
import dto.PessoaDTO;
import util.DateUtils;

public class PessoaDAO extends BaseDAO {

    public PessoaDAO(final ConexaoStrategy conexao) {
        super(conexao);
    }

    public PessoaDAO() {
        super(new ConexaoMySQL());
    }

    public List<PessoaDTO> consultarTodos() {
        final List<PessoaDTO> pessoas = new ArrayList<>();
        return execute((connection) -> {
            final Statement statement = connection.createStatement();
            this.resultado = statement.executeQuery(CONSULTAR_TODAS_PESSOAS);

            while (resultado.next()) {
                final PessoaDTO pessoa = new PessoaDTO();
                pessoa.setId_pessoa(resultado.getLong("id"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setDt_nasc(resultado.getObject("data_nascimento", LocalDate.class));
                pessoa.setCelular(resultado.getString("celular"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setSetor(resultado.getString("setor"));
                pessoa.setOcupacao(resultado.getString("ocupacao"));
                pessoa.setOrigem(resultado.getString("origem"));
                pessoa.setDt_hr_origem(resultado.getObject("data_hora_origem", LocalDateTime.class));
                pessoa.setTipo_pessoa(resultado.getString("tipo_pessoa"));

                final EnderecoDTO endereco = new EnderecoDTO();
                endereco.setId_endereco(resultado.getLong("id_endereco"));
                endereco.setCidade(resultado.getString("cidade"));
                endereco.setUf(resultado.getString("uf"));
                pessoa.setEndereco(endereco);

                pessoas.add(pessoa);
            }
            return pessoas;
        });
    }

    public PessoaDTO criar(final PessoaDTO pessoa) {
        return execute((connection) -> {
            ResultSet pessoaResultSet = null;
            final PreparedStatement pessoaStmt = connection.prepareStatement(CRIAR_PESSOA,
                RETURN_GENERATED_KEYS);

            pessoaStmt.setString(1, pessoa.getNome());
            pessoaStmt.setDate(2, Date.valueOf(pessoa.getDt_nasc()));
            pessoaStmt.setString(3, pessoa.getEmail());
            pessoaStmt.setString(4, pessoa.getOcupacao());
            pessoaStmt.setString(5, transformDateTime(pessoa.getDt_hr_origem()));
            pessoaStmt.setString(6, pessoa.getCelular());
            pessoaStmt.setString(7, pessoa.getOrigem());
            pessoaStmt.setString(8, pessoa.getTipo_pessoa());

            pessoaStmt.executeUpdate();

            try {
                pessoaResultSet = pessoaStmt.getGeneratedKeys();
                if (pessoaResultSet.next()) {
                    pessoa.setId_pessoa(pessoaResultSet.getLong(1));
                }
            } finally {
                conexao.fechar(pessoaResultSet);
            }


            if (nonNull(pessoa.getEndereco())) {
                ResultSet enderecoResultSet = null;
                final EnderecoDTO endereco = pessoa.getEndereco();
                final PreparedStatement enderecoStmt = connection.prepareStatement(CRIAR_ENDERECO,
                    RETURN_GENERATED_KEYS);

                enderecoStmt.setString(1, endereco.getUf());
                enderecoStmt.setString(2, endereco.getCidade());
                enderecoStmt.setLong(3, pessoa.getId_pessoa());

                enderecoStmt.executeUpdate();

                try {
                    enderecoResultSet = enderecoStmt.getGeneratedKeys();
                    if (enderecoResultSet.next()) {
                        endereco.setId_endereco(enderecoResultSet.getLong(1));
                        pessoa.setEndereco(endereco);
                    }
                } finally {
                    conexao.fechar(enderecoResultSet);
                }
            }

            conexao.fechar(pessoaResultSet);

            return pessoa;
        });
    }

    public void deletar(final Long id) {
        execute((connection) -> {
            final PreparedStatement preparedStmt = connection.prepareStatement(DELETAR_PESSOA_ID);

            preparedStmt.setLong(1, id);

            preparedStmt.execute();
        });
    }

    public void deletar(final PessoaDTO pessoa) {
        execute((connection) -> {
            final PreparedStatement preparedStmt = connection.prepareStatement(DELETAR_PESSOA_ID);

            preparedStmt.setLong(1, pessoa.getId_pessoa());

            preparedStmt.execute();
        });
    }
}
