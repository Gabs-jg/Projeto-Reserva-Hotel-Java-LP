package Entities;

import Entities.Enum.Status;
import Entities.Enum.TipoQuarto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Reserva {
    private static int geradorId;
    private int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Quarto quarto;
    private double valorTotal;
    private Cliente cliente;
    private Status status;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva(Cliente cliente, LocalDate dataInicio, LocalDate dataFim, Quarto quarto) {
        this.cliente = cliente;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.id = geradorId++;
        this.quarto = quarto;
    }

    public double calcularValorTotalReserva() {
        long dias = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;
        return dias * quarto.getValorDiaria();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
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

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva: " + cliente +
                ", id=" + id +
                ", dataInicio =" + dataInicio.format(fmt) +
                ", dataFim =" + dataFim.format(fmt) +
                ", quarto =" + quarto.getNumero() +
                ", valorTotal =" + calcularValorTotalReserva() +
                "\n";
    }
}


