package dto;

import static java.lang.String.format;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaDTO {

    private Long id_pessoa;
    private String nome;
    private EnderecoDTO endereco;
    private LocalDate dt_nasc;
    private String celular;
    private String email;
    private String setor;
    private String cargo;
    private String ocupacao;
    private Long id_origem;
    private LocalDateTime dt_hr_origem;
    private String tipo_pessoa;


    public Long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(final Long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(final EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(final LocalDate dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(final String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(final String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(final String cargo) {
        this.cargo = cargo;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(final String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Long getId_origem() {
        return id_origem;
    }

    public void setId_origem(final Long id_origem) {
        this.id_origem = id_origem;
    }

    public LocalDateTime getDt_hr_origem() {
        return dt_hr_origem;
    }

    public void setDt_hr_origem(final LocalDateTime dt_hr_origem) {
        this.dt_hr_origem = dt_hr_origem;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(final String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    @Override
    public String toString() {
        return format("%s: %s;\t %s: %s;\t %s: %s;\t",
            "Nome", getNome(),
            "Ocupação", getOcupacao(),
            "Tipo pessoa", getTipo_pessoa());
    }
}
