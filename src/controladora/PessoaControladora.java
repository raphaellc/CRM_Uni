package controladora;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static util.ValorUtil.isEmptyString;
import static util.ValorUtil.isNotEmptyString;

import java.util.List;

import dto.EnderecoDTO;
import dto.PessoaDTO;
import modelo.PessoaModelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PessoaControladora {

    private final PessoaModelo modelo;

    public PessoaControladora() {
        final String enviroment = System.getenv("DB_TYPE");
        final String tipoBanco = isNotEmptyString(enviroment) ? enviroment : "MySQL";
        this.modelo = new PessoaModelo(tipoBanco);
    }

    public List<PessoaDTO> listar() {
        return modelo.consultarTodos();
    }

    public boolean cadastrar(PessoaDTO pessoaDTO) {

        if (!validarCadastroPessoa(pessoaDTO)) {
            return false;
        }

        return modelo.cadastrar(pessoaDTO);
    }

    public boolean atualizar(PessoaDTO pessoaDTO) {

        if (!validarCadastroPessoa(pessoaDTO)) {
            return false;
        }

        return modelo.atualizar(pessoaDTO);
    }

    public void deletar(final PessoaDTO pessoaDTO) {
        modelo.deletar(pessoaDTO.getId_pessoa());
    }

    private boolean validarCadastroPessoa(PessoaDTO pessoaDTO) {
        if (isNull(pessoaDTO)) {
            return false;
        }

        if (!isEmail(pessoaDTO.getEmail())) {
            return false;
        }

        if (isEmptyString(pessoaDTO.getNome())) {
            return false;
        }
        if (isNull(pessoaDTO.getDt_nasc())) {
            return false;
        }
        if (isEmptyString(pessoaDTO.getCelular())) {
            return false;
        }

        return validarCadastroEndereco(pessoaDTO.getEndereco());
    }

    private boolean validarCadastroEndereco(EnderecoDTO enderecoDTO) {
        if (nonNull(enderecoDTO)) {
            if (isEmptyString(enderecoDTO.getCidade())) {
                return false;
            }

            if (isEmptyString(enderecoDTO.getBairro())) {
                return false;
            }

            if (isEmptyString(enderecoDTO.getLogradouro())) {
                return false;
            }

            if (isEmptyString(enderecoDTO.getEstado())) {
                return false;
            }

            if (isEmptyString(enderecoDTO.getCep())) {
                return false;
            }

            return !isEmptyString(enderecoDTO.getNumero());
        }

        return true;
    }

    private boolean isEmail(String email){

        if(isEmptyString(email)){
            return false;
        }

        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

}
