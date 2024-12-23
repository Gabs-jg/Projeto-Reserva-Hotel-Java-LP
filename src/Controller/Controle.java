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


    public void criarReserva(int clienteId, int numeroQuarto, Date dataInicio, Date dataFim) {
      Cliente cliente = getCliente(clienteId);
      Quarto quarto = getQuarto(numeroQuarto);
      if(cliente == null || quarto == null || quarto.getStatus() == Status.OCUPADO){
          throw new IllegalArgumentException("Quarto ou cliente inválido ou quarto não disponível");
      }

      Reserva reserva = new Reserva(cliente,dataFim,dataInicio,clienteId,quarto);
      reservas.add(reserva);
      quarto.setStatus(Status.RESERVADO);
    }

    public String imprimirReservas() {

    }

    public String imprimirReservasCliente(String nomeCliente) {

    }

    public String imprimirReservasPeriodo(String dataInicial, String dataFinal) {

    }

    public String imprimirQuartosNaoOcupados() {

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

    private Quarto getQuarto(int numeroQuarto) {

    }

    private Cliente getCliente(int id){

    }

    private boolean quartoEstaCadastrado(String numeroQuarto) {

    }


}
