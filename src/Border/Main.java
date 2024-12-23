package Border;

import Controller.Controle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controle hotel = new Controle();

        int opcao;
        do {

            System.out.println("Digite a opção que deseja:\n" +
                    "0 - Sair\n" +
                    "1 - Criar reserva\n" +
                    "2 - Alterar uma reserva.\n" +
                    "3 - Imprimir uma reserva.\n" +
                    "4 - Imprimir todas as reservas.");


            opcao = sc.nextInt();


            switch (opcao) {
                case 1:
                    hotel.criarReserva();
                    break;
                case 2:
                    System.out.println("Digite o ID da reserva:");
                    int idReserva = sc.nextInt();
                    hotel.ocuparQuartos(idReserva);
                    break;
                case 3:
                    System.out.println("Digite o nome do cliente:");
                    String nomeDoCliente = sc.nextLine();
                    hotel.imprimirReservaNome(nomeDoCliente);
                    break;
                case 4:
                    hotel.imprimirTodos();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, tente novamente!");
                    break;
            }
        } while (opcao != 0);

        }
    }