package dtos;

import java.util.Date;

public class AtendimentoDto {
    private int idAtendimento;
    private int idPessoa;
    private int idCategoria;
    private int idResponsavel;
    private int idProduto;
    private Date dtAbertura;
    private Date dtResolucao;
    private String descProblema;
    private String prioridadeCaso;

    //Construtor

    public AtendimentoDto() {
    }

    //Getters e Setters

    public int getIdAtendimento() {
        return idAtendimento;
    }
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }
    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public int getIdResponsavel() {
        return idResponsavel;
    }
    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public Date getDtAbertura() {
        return dtAbertura;
    }
    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }
    public Date getDtResolucao() {
        return dtResolucao;
    }
    public void setDtResolucao(Date dtResolucao) {
        this.dtResolucao = dtResolucao;
    }
    public String getDescProblema() {
        return descProblema;
    }
    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }
    public String getPrioridadeCaso() {
        return prioridadeCaso;
    }
    public void setPrioridadeCaso(String prioridadeCaso) {
        this.prioridadeCaso = prioridadeCaso;
    }
}
