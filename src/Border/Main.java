package Border;

import Controller.Controle;
import Entities.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controle hotel = new Controle();
        Cliente cliente = new Cliente();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        int opcao;
        do {

            System.out.println("""
                    Digite a opção que deseja:
                    0-Sair.\s
                    1-Criar reserva.\s
                    2-Cadastrar quarto.\s
                    3-Cadastrar cliente.\s
                    4-Imprimir todas as reservas.\s
                    5-Imprimir uma reserva informando o nome do cliente.\s
                    6-Imprimir clientes cadastrados.\s
                    7-Imprimir quartos cadastrados.\s
                    8-Alterar uma reserva informando o id da reserva para que o quarto se torne ocupado.\s
                    9-Buscar e imprimir reservas pelo número do quarto.\s
                    10-Imprimir todos os quartos não ocupados.\s
                    11-Imprimir reservas de um período.""");


            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Insira o número do quarto: ");
                    int numeroQuarto = sc.nextInt();
                    System.out.print("Insira a data de ínicio da reserva:");
                    String data = sc.next().trim();
                    LocalDate dataInicio = LocalDate.parse(data, fmt);
                    System.out.print("Digite a data final da reserva: ");
                    String data2 = sc.next().trim();
                    LocalDate dataFim = LocalDate.parse(data2, fmt);
                    System.out.print("Informe o ID do cliente: ");
                    int clienteID = sc.nextInt();
                    hotel.criarReserva(clienteID, numeroQuarto, dataInicio, dataFim);
                    System.out.println();
                    break;

                case 2:
                    hotel.cadastrarQuarto();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Digite o nome do cliente: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    hotel.cadastrarCliente(nome);
                    System.out.println();
                    break;

                case 4:
                    System.out.println(hotel.imprimirReservas());
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Insira o nome do cliente para pesquisa: ");
                    String nomeCliente = sc.next().trim();
                    System.out.println(hotel.imprimirReservasCliente(nomeCliente));
                    System.out.println();
                    break;

                case 6:
                    System.out.println(hotel.imprimirClientes());
                    System.out.println();
                    break;

                case 7:
                    System.out.println(hotel.imprimirQuartos());
                    System.out.println();
                    break;

                case 8:
                    System.out.print("Insira o ID da reserva: ");
                    int idReserva = sc.nextInt();
                    hotel.ocuparQuarto(idReserva);
                    System.out.println();
                    break;

                case 9:
                    System.out.print("Informe o número do quarto: ");
                    int numQuarto = sc.nextInt();
                    hotel.imprimirReservasQuarto(numQuarto);
                    System.out.println();
                    break;

                case 10:
                    System.out.println(hotel.imprimirQuartosNaoOcupados());
                    System.out.println();
                    break;

                case 11:
                    System.out.print("Insira a primeira data: ");
                    String primeiraData = sc.next();
                    LocalDate firstDate = LocalDate.parse(primeiraData, fmt);
                    System.out.print("Insira a última data: ");
                    String ultimaDate = sc.next();
                    LocalDate finalDate = LocalDate.parse(ultimaDate, fmt);
                    hotel.imprimirReservasPeriodo(firstDate, finalDate);
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção Inválida. Tente novamente!");
                    System.out.println();
            }

        } while (opcao != 0);

        sc.close();

    }

}