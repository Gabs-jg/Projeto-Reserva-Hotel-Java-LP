package Entities.Enum;

public enum TipoQuarto {
    LUXO("Luxo", 300),
    STANDARD("Standard", 180);

    private String tipoQuarto;
    private double valorDiaria;

    TipoQuarto(String tipoQuarto, double valorDiaria) {
        this.tipoQuarto = tipoQuarto;
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public String toString() {
        return  "tipoQuarto = '" + tipoQuarto + '\'' +
                ", valorDiaria = " + valorDiaria
                ;
    }


}
