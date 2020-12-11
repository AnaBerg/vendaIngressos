package Main;

import java.util.Date;
import View.TelaInicial;

import Model.Evento;

public class Main {
    public static void main(String[] args) {
    	Date data = new Date();
        Evento evento = new Evento(1, "ART", "baia", "damiani", 100, data, 1);
        System.out.println(evento);
        
        TelaInicial objeto = new TelaInicial();
        objeto.setVisible(true);
    }
}
