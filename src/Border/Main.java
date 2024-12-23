package Border;

import Controller.Controle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controle hotel = new Controle();

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
                    8- Alterar uma reserva informando o id da reserva para que o quarto se torne ocupado.\s
                     9-Buscar e imprimir reservas pelo número do quarto.\s
                    10-Imprimir todos os quartos não ocupados.\s
                     11-Imprimir reservas de um período.""");


            opcao = sc.nextInt();
3

        } while (opcao != 0);

    }
}