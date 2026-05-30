import java.util.Arrays;

public class DequeExe {
    public static void main(String[] args) {
        Deque<String> listaCompra = new Deque();

        listaCompra.insertFront("Óvios");
        listaCompra.insertFront("Arroz");
        listaCompra.insertFront("Feijão");

        System.out.println(listaCompra.print());

        listaCompra.insertBack("Sabonete");
        listaCompra.insertBack("Água sanitária");
        listaCompra.insertBack("Vassoura");
        listaCompra.insertBack("Shampoo");

        System.out.println(listaCompra.print());

        listaCompra.removeFront();
        listaCompra.removeBack();

        System.out.println(listaCompra.print());
        System.out.println("Primeiro item da lista: " + listaCompra.peakFront());
        System.out.println("Último item da lista: " + listaCompra.peakBack());
    }
}