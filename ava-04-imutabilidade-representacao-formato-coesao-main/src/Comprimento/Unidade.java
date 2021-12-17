package Comprimento;

public enum Unidade {
    POLEGADA(39.37), CENTIMENTRO(0.150),
    METRO(100.0), KILOMETRO(0.1);

    private double numero;

    private Unidade(double numero){
        this.numero = numero;
    }

    
}
