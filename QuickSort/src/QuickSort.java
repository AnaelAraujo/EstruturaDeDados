import java.util.Arrays;

//métodos de organização
public class QuickSort {
    public static void quickSort(Comparable[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private static void quickSort(Comparable[] vetor, int inicio, int fim) {
        if(inicio < fim) {
            int pivo = particionar(vetor, inicio,fim);

            quickSort(vetor, inicio, pivo - 1);   // ordena a sublista menor que o pivô (à esquerda)
            quickSort(vetor, pivo + 1, fim);    // ordena a sublista maior que o pivô (à direita)
        }
    }

    private static int particionar(Comparable[] vetor, int inicio, int fim) {
        Comparable pivo = vetor[fim];
        //o "i" raastreia a posição do último elemento menor que o pivô encontrato
        int i = inicio - 1;

        //o "j" percorre o vetor do inicio até o penúltimo elemento
        for(int j = inicio; j < fim; j++) {
            if(vetor[j].compareTo(pivo) < 0) {
                i++; //avanca o indice do "limite dos menores"
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, i + 1, fim);
        return i + 1;

    }
    private static void trocar(Comparable[] vetor, int i, int j) {
        Comparable temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
    public static void main(String[] args) {
        Integer[] nums = {77, 44, 22, 33, 99, 55, 88, 0, 66, 11};
        String[] nomes = {"Maria", "João", "Ana", "Carlos", "Beatriz"};

        quickSort(nums);
        System.out.println("números ordenados: " + Arrays.toString(nums));

        quickSort(nomes);
        System.out.println("nomes ordenados: " + Arrays.toString(nomes));
    }
}
