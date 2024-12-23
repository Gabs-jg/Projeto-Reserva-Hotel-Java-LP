package Controller;

import Entities.Cliente;
import Entities.Quarto;
import Entities.Reserva;
import Enum.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Controle {

    private List<Reserva> reservas = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();


    public void criarReserva(int clienteId, String numeroQuarto, Date dataInicio, Date dataFim) {
        Cliente cliente = getCliente(clienteId);
        Quarto quarto = getQuarto(numeroQuarto);
        if (cliente == null || quarto == null || quarto.getStatus() != Status.LIVRE) {
            throw new IllegalArgumentException("Quarto ou cliente inválido ou quarto não disponível");
        }

        Reserva reserva = new Reserva(cliente, dataFim, dataInicio, clienteId, quarto);
        reservas.add(reserva);
        quarto.setStatus(Status.RESERVADO);
    }

    public String imprimirReservas() {
        if (!reservas.isEmpty()) {
            return reservas.toString();
        } else {
            return "Reservas não encontradas!";
        }
    }

    public String imprimirReservasCliente(String nomeCliente) {
        StringBuilder sb = new StringBuilder("Reservas do cliente").append(":\n");
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getNome().equalsIgnoreCase(nomeCliente)) ;
            sb.append(reserva).append("\n");
        }

        return sb.toString();
    }

    public String imprimirReservasPeriodo(Date dataInicial, Date dataFinal) {
        StringBuilder sb = new StringBuilder("Reservas no período de ")
                .append(dataInicial).append(" a ").append(dataFinal).append("\n");
        for (Reserva r : reservas) {
            if (!r.getDataInicio().after(dataFinal) && !r.getDataFim().before(dataInicial)) {
                sb.append(sb).append("\n");
            }
        }
        return sb.toString();
    }

    public String imprimirQuartosNaoOcupados() {
        StringBuilder sb = new StringBuilder("Quartos que não estão ocupados: \n");
        for (Quarto quarto : quartos) {
            if (quarto.getStatus() == Status.LIVRE) {
                sb.append(quarto).append("\n");
            }
        }
        return sb.toString();

    }

    public String imprimirQuartos() {

    }

    public String imprimirClientes() {

    }

    public void mudarStatusVenda(int idVenda) {

    }

    public void ocuparQuarto(int idReserva) {

    }

    public void cadastrarQuarto() {

    }

    public void cadastrarCliente() {

    }

    private Quarto getQuarto(String numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (String.valueOf(quarto.getNumero()).equals(numeroQuarto)) {
                return quarto;
            }
        }
        return null;
    }

    private Cliente getCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;

    }

    private boolean quartoEstaCadastrado(String numeroQuarto) {
        return getQuarto(numeroQuarto) != null;
    }


}
