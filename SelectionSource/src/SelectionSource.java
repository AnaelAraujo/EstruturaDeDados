import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class SelectionSource {
    public static <SS extends Comparable<SS>> void selectionSource(SS[] vetor) {
        for(int posSel = 0; posSel < vetor.length - 1; posSel++) {
            int menor = posSel;

            for(int comp = menor + 1; comp < vetor.length; comp++) {
                if(vetor[comp].compareTo(vetor[menor]) < 0) {
                    menor = comp;
                }
            }

            if(vetor[posSel].compareTo(vetor[menor]) > 0) {
                SS temp = vetor[posSel];
                vetor[posSel] = vetor[menor];
                vetor[menor] = temp;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Integer[] nums = {77, 44, 22, 33, 99, 55, 88, 0, 66, 11};
        String[] nomesDesordenados = {"Maria", "João", "Ana", "Carlos", "Beatriz", "Adão", "Eva"};

        selectionSource(nums);
        System.out.println("Números organizados = " + Arrays.toString(nums));

        selectionSource(nomesDesordenados);
        System.out.println("Nomes (agora Ordenados) = " + Arrays.toString(nomesDesordenados));

        Path caminho = Path.of("data/nomes-desord.txt");
        List<String> lista = Files.readAllLines(caminho);

        String[] nomes = lista.toArray(new String[0]);

        long inicio = System.currentTimeMillis();

        selectionSource(nomes);
        for(String nome : nomes) {
            System.out.println(nome);
        }
        long fim = System.currentTimeMillis();

        System.out.println("Tempo de Ordenação de nomes-desord.txt: " + (fim - inicio) + "ms");
    }
}
