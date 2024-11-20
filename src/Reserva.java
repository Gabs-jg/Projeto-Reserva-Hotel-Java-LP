import java.util.Date;

public class Reserva {
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private Quarto quarto;
    private double valorTotal;
    private Cliente cliente;

    //construtor e métodos get e set

    public String toString() {
        /* Chamado quando solicitar a impressâo de reservas. Mostrar todos
        os dados, como nome do cliente, datas e valor de reserva, número
        e tipo de quarto.
         */
        return "oi";
    }
}


