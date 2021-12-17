package Comprimento;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import Comprimento.Unidade;

public class Comprimento {
    
    public final int milimetros;
    
    public Comprimento(){
        this.milimetros = 0;
    }

    public Comprimento(double d) {
        if(d < 0){
            throw new IllegalStateException("Não existe medida negativa!");
        }
        this.milimetros = (int)(d * 1000);
    }

    public Comprimento(int x){
        if(x < 0){
            throw new IllegalStateException("Não existe medida negativa!");
        }
        this.milimetros = x;
    }
    public static Comprimento fromPolegadas(double d) {
        int x = (int) (d * 25.4);
        x = (int) Math.floor(x * 100) / 100;
        Comprimento temp = new Comprimento(x);
        return temp;
    }

    public static Comprimento fromString(String string) {
        boolean x = false;
        String y = string;
        String temp3 = string.replaceAll("[^-?0-9]+", "");
        
        if(x == true){
            throw new IllegalArgumentException("String em formato não aceitado.");
        }

        return null;
    }

    public double getCentimetros() {
        return 0;
    }

    public double getMetros() {
        return 0;
    }

    public double getPolegadas() {
        return 0;
    }

    public int getMilimetros() {
        return 0;
    }

    public Comprimento mais(Comprimento umMetroMeio) {
        return null;
    }

    public Comprimento mais(double d) {
        return null;
    }

    public Comprimento dobro() {
        return null;
    }

    public Comprimento vezes(int i) {
        return null;
    }
}
