import java.util.ArrayList;
import java.util.Arrays;

public class Pilha1 {
    public static void main(String[] args) {
        String frase = "Say my name.";
        ArrayList<Character> vetor = new ArrayList<Character>();

        //percorre a frase e coloca cada uma das letras dentro da lista
        for(int i = 0; i < frase.length(); i++) {
            //se fode
            vetor.add(frase.charAt(i));
            System.out.println(vetor);
        }
        System.out.println("RESULTADO FINAL: " + vetor);


        //descaracterização de pilha
        vetor.add(0, 'X');
        vetor.add(11, 'W');
        vetor.remove(5);
    }
}