//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BuscaBinaria {
    public static void main(String[] args) {
        Integer[] nums = {0, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100};
        String[] nomes = {"ADAMASTOR", "ALEXANDRE", "ANA", "CARLOS", "DANIEL", "FERNANDO", "GUSTAVO", "JERDERSON", "MARIA", "ZULEIDE"};

        System.out.println("Posição do vetor nums: " + BuscaBinariaI(nums, 77));
        System.out.println("Posição do vetor nums: " + BuscaBinariaI(nums, 81));
        System.out.println("Posição do vetor nomes: " + BuscaBinariaS(nomes, "ADAMASTOR"));
        System.out.println("Posição do vetor nomes: " + BuscaBinariaS(nomes, "ZULEIDE"));
        System.out.println("Posição do vetor nomes: " + BuscaBinariaS(nomes, "ISIS"));
    }
    public static int BuscaBinariaI(Integer[] vetor, Integer valorBusca) {
        int ini = 0;
        int fim = vetor.length - 1;

        while(fim >= ini) {
            int meio = (fim + ini) / 2;

            if(valorBusca == vetor[meio]) {
                return meio;
            } else if (valorBusca > vetor[meio]) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
    public static int BuscaBinariaS(String[] vetor, String valorBusca) {
        int ini = 0;
        int fim = vetor.length - 1;

        int meio = 0;
        int comparador = valorBusca.compareTo(vetor[meio]);

        while (fim >= ini) {
            meio = (fim + ini) / 2;

            if (vetor[meio].equals(valorBusca)) {
                return meio;
            } else if (comparador > 0) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}

