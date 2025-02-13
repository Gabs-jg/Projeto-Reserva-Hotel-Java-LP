package Entities;

public class Cliente {
    private static int geradorId;
    private int id;
    private String nome;

    public Cliente() {
    }

    public Cliente(String nome) {
        this.id = geradorId++;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id =" + id +
                ", nome ='" + nome + '\'' +
                '}';
    }
}
