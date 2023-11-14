package dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class AtendimentoDto {
    private int idAtendimento;
    private int idPessoa;
    private int idCategoria;
    private int idResponsavel;
    private int idProduto;
    private LocalDate dtAbertura;
    private LocalDate dtResolucao;
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
    public LocalDate getDtAbertura() {
        return dtAbertura;
    }
    public LocalDate getDtResolucao() {
        return dtResolucao;
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
