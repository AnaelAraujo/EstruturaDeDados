import java.util.Arrays;

public class BubbleSort {
    public static <BS extends Comparable<BS>> void bubbleSort(BS[] vetor) {
        boolean trocou;

        do {
            trocou = false;
            for(int i = 0; i < vetor.length - 1; i++) {
                if(vetor[i].compareTo(vetor[i + 1]) > 0) {
                    BS temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);
    }
    public static void main(String[] args) {
        Integer[] nums = {77, 44, 67, 22, 33, 99, 55, 88, 0, 66, 11};
        String[] nomesDesord = {"MARIA", "JOAO", "ANA", "CARLOS", "BEATRIZ"};
        System.out.println("numeros desorganizados" + nums);
    }

}
