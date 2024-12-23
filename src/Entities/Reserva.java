package Entities;

import java.util.Date;

public class Reserva {
    private static int geradorId;
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private Quarto quarto;
    private double valorTotal;
    private Cliente cliente;

    public Reserva(Cliente cliente, Date dtaFim, Date dataIniacio, int clienteId, Quarto quarto) {
        this.cliente = cliente;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.id = geradorId++;
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public static int getGeradorId() {
        return geradorId;
    }

    public static void setGeradorId(int geradorId) {
        Reserva.geradorId = geradorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", quarto=" + quarto +
                ", valorTotal=" + valorTotal +
                '}';
    }
}


