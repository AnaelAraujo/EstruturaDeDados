import java.sql.SQLOutput;
import java.util.Arrays;

public class Pilha2 {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        System.out.println(pilha.print());
        System.out.println("Está vazia? " + (pilha.isEmpty() ? "sim" : "não"));
        System.out.println("============================================");
        pilha.push(67);
        pilha.push(77);
        pilha.push(19);
        System.out.println(pilha.print());
        System.out.println("Está vazia? " + (pilha.isEmpty() ? "sim" : "não"));
        System.out.println("============================================");

        Integer removido = pilha.pop();
        System.out.println("pilha: " + pilha.print());
        System.out.println("último (topo): " + pilha.peak());
    }
}