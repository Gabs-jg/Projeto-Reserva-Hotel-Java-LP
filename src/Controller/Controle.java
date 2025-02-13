package Controller;

import Entities.Cliente;
import Entities.Quarto;
import Entities.Reserva;
import Entities.Enum.Status;
import Entities.Enum.TipoQuarto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controle {

    private List<Reserva> reservas = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    public void criarReserva(int clienteId, int numeroQuarto, LocalDate dataInicio, LocalDate dataFim) {
        Cliente cliente = getCliente(clienteId);
        Quarto quarto = getQuarto(numeroQuarto);

        if (cliente == null || quarto == null || quarto.getStatus() != Status.LIVRE) {
            System.err.println("Quarto/cliente inválido ou quarto indisponível. Tente novamente!");
            return;
        }

        Reserva reserva = new Reserva(cliente, dataInicio, dataFim, quarto);
        reservas.add(reserva);
        quarto.setStatus(Status.RESERVADO);
        System.out.println("Sua reserva foi criada com sucesso! \n " + reserva);
    }

    public String imprimirReservas() {
        if (!reservas.isEmpty()) {
            System.out.println("As reservas encontradas foram: ");
            return reservas.toString();
        } else {
            return "Reservas não encontradas!";
        }
    }

    public String imprimirReservasCliente(String nomeCliente) {
        StringBuilder sb = new StringBuilder("Reservas do cliente").append(":\n");
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getNome().trim().equalsIgnoreCase(nomeCliente)) {
                sb.append(reserva).append("\n");
            } else {
                return "Não existe nenhuma reserva neste nome!";
            }
        }

        return sb.toString();
    }

    public void imprimirReservasPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        StringBuilder sb = new StringBuilder("Reservas no período de ").append(dataInicial).append(" a ").append(dataFinal).append("\n");
        boolean reservaEncontrada = false;
        for (Reserva r : reservas) {
            if (!r.getDataInicio().isAfter(dataFinal) && !r.getDataFim().isBefore(dataInicial)) {
                sb.append(r).append("\n");
                reservaEncontrada = true;
            }
        }

        if (!reservaEncontrada){
            sb.append("Não existem reservas cadastradas nesse período");
        }

        System.out.println(sb);
    }

    public String imprimirQuartosNaoOcupados() {
        StringBuilder sb = new StringBuilder("Quartos que não estão ocupados: \n");
        boolean livre = false;
        for (Quarto quarto : quartos) {
            if (quarto.getStatus() == Status.LIVRE) {
                sb.append(quarto).append("\n");
                livre = true;
            }
        }

        if (!livre) {
            return "Não há quartos livres no momento.";
        }

        return sb.toString();

    }

    public String imprimirQuartos() {
        if (quartos.isEmpty()) {
            return "Não existe quarto cadastrado.";
        }

        StringBuilder sb = new StringBuilder();
        for (Quarto quarto : quartos) {
            sb.append(quarto).append("\n");
        }

        return sb.toString();
    }


    public String imprimirClientes() {
        if (clientes.isEmpty()) {
            return "Não existe nenhum cliente cadastrado.";
        }

        StringBuilder sb = new StringBuilder("Lista de Clientes: \n");
        for (Cliente cliente : clientes) {
            sb.append(cliente).append("\n");
        }

        return sb.toString();

    }

    public void ocuparQuarto(int idReserva) {
        StringBuilder sb = new StringBuilder();
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                reserva.getQuarto().setStatus(Status.OCUPADO);
                System.out.println("Quarto da reserva(ID) " + idReserva + " foi marcado como OCUPADO");
                return;
            }
        }

        System.err.println("Reserva com o ID " + idReserva + " não foi encontrada.");
    }

    public void cadastrarQuarto() {
        System.out.println("Digite o tipo de quarto (Luxo/Standard): ");
        String tipoQuarto = sc.next().toUpperCase();
        TipoQuarto tipo = TipoQuarto.valueOf(tipoQuarto);

        if (TipoQuarto.LUXO == tipo) {
            System.out.println("Você cadastrou " + tipo);
        } else if (TipoQuarto.STANDARD == tipo) {
            System.out.println("Você cadastrou " + tipo);
        } else {
            System.err.println("Você escolheu um tipo inválido. Tente novamente!");
            return;
        }

        System.out.println("Informe o número do quarto: ");
        int numeroQuarto = sc.nextInt();
        Quarto novoQuarto = new Quarto(numeroQuarto, tipo);

        for (Quarto quarto : quartos) {
            if (numeroQuarto == quarto.getNumero()) {
                System.err.println("Esse quarto já está cadastrado no sistema!");
                return;
            }
        }

        quartos.add(novoQuarto);
        quartoEstaCadastrado(numeroQuarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    public void imprimirReservasQuarto(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto() != null && reserva.getQuarto().getNumero() == numeroQuarto) {
                System.out.println("Reserva encontrada: \n " + reserva);
                return;
            }
        }

        System.err.println("Não existe reserva para esse quarto.");
    }

    public void cadastrarCliente(String nomeCliente) {
        Cliente cliente = new Cliente(nomeCliente);
        for (Cliente cl : clientes) {
            if (cl.getNome().equalsIgnoreCase(nomeCliente)) {
                System.out.println("Já existe cadastro");
                return;
            }
        }

        clientes.add(cliente);
        System.out.println("Cadastrado realizado com sucesso! \n " + cliente);
    }

    private Quarto getQuarto(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
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

    private boolean quartoEstaCadastrado(int numeroQuarto) {
        return getQuarto(numeroQuarto) != null;
    }


}
