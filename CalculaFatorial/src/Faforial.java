public class Faforial {
    public static long fatorial(int n) {
        long res = 1;
        for(int i = n; i > 1; i--) {
            res *= i;
        }
        return res;
    }

    public static long fatorialRec(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * fatorialRec(n - 1);
    }
    public static void main(String[] args) {
        System.err.println("fatorial de 9: " + fatorial(9));
        System.err.println("fatorial de 5 recursivo: " + fatorialRec(5));

    }
}
