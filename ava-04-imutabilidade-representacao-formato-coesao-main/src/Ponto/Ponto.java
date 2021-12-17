package Ponto;

public class Ponto {

    private String nome;
    private int ponto;

    public Ponto(String string) {
        this.nome = string;
    }

    public void bater(String string) {
        String hr = " ", mi = " ", se =" ";
        hr = string.substring(0,2);
        mi = string.substring(3,5);
        se = string.substring(6,8);
        this.ponto = (Integer.parseInt(hr) * 3600) +
        (Integer.parseInt(mi) * 60)
        + Integer.parseInt(se);
    }

}
