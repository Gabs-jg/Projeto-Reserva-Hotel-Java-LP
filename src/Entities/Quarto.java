package Entities;

import Enum.TipoQuarto;
import Enum.Status;

public class Quarto {
    private static int geradorId;
    private int id;
    private int numero;
    private Status status;
    private TipoQuarto tipoQuarto;

    public Quarto(int numero, TipoQuarto tipoQuarto) {
        this.id = geradorId++;
        this.numero = numero;
        this.status = Status.LIVRE;
        this.tipoQuarto = tipoQuarto ;
    }

    public int getNumero() {
        return numero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
