import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> data;

    public Stack() {
        this.data = new ArrayList<T>();
    }

    // método de inserção da pilha
    public void push(T val) {
        System.out.println("Foi adicionado um valor na pilha. (" + val + ")");
        this.data.add(val);
    }

    //método de remoção da pilha
    public T pop() {
        int cum = this.data.size() - 1;
        if(isEmpty()) return null;
        System.out.println("O último valor da pilha foi removido. (" + getT(cum) + ")");
        return this.data.remove(cum);
    }

    private T getT(int cum) {
        return this.data.get(cum);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    //método para consultar o topo (última posição) da pilha (sem remover elemento)
    public T peak() {
        if(isEmpty()) return null;
        return this.data.get(this.data.size() - 1);
    }

    //método que imprime a pilha para efeitos de depuração
    public String print() {
        return this.data.toString();
    }
}