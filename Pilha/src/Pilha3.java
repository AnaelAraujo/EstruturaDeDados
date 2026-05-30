import java.util.Arrays;

public class Pilha3 {
    public static void main(String[] args) {
        String frase = "Socorram-me, subi no ônibus em Marrocos";
        Stack<Character> pilha = new Stack<Character>();
        for(int i = 0; i < frase.length(); i++) {
            pilha.push(frase.charAt(i));
        }
        System.out.println("Pilha original: " + pilha.print());

        String reverso = "";
        while(!pilha.isEmpty()) {
            reverso += pilha.pop();
        }

        System.out.println("Pilha invertida: " + reverso);
    }
}
