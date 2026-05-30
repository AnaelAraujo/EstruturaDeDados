import java.util.Arrays;

public class MergeSort {
    public <MS extends Comparable<MS>> void mergeSort(MS[] vetor) {
        //caso base: se o vetor tem 0 ou 1 elementos, já está "ordenado".
        if(vetor.length < 2) return;

        int meio = vetor.length / 2;

        MS[] vetEsq = Arrays.copyOfRange(vetor, 0, meio);
        MS[] vetDir = Arrays.copyOfRange(vetor, meio, vetor.length);

        //chamadas recursivas
        mergeSort(vetEsq);
        mergeSort(vetDir);
        int posEsq = 0, posDir = 0, posRes = 0;
        while(posEsq < vetEsq.length && posDir < vetDir.length) {
            if(vetEsq[posEsq].compareTo(vetDir[posDir]) < 0) {
                vetor[posRes] = vetEsq[posEsq];
                posEsq++;
            } else {
                vetor[posRes] = vetDir[posDir];
                posDir++;
            }
            posRes++;
        }
    }
    public static void main(String[] args) {
        Integer[] nums = {99, 44, 77, 0, 22, 66, 33, 55, 11, 88, 55};
        String[] nomesDesord = {"Maria", "João", "Ana", "Carlos", "Beatriz"};
    }
}