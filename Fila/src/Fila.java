import java.util.ArrayList;
import java.util.Arrays;

public class Fila {
    public static void main(String[] args) {
        Queue<String> fila = new Queue();
        fila.enfil("Humpty");
        fila.enfil("Adão");
        fila.enfil("Eva");
        fila.enfil("Jhonny Joestar");
        fila.enfil("Dio Brando");

        System.out.println(fila.print());
        System.out.println("Próximo da fila: " + fila.peak());

        //chamada do próximo (a ser atendido)
        String atendido = fila.desenfil();

        System.out.println(atendido + ", favor dirija-se para o local de abate.");

        System.out.println("fila atual: " + fila.print());
    }
}
