import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> data; //lista privada
    public Queue() {
        this.data = new ArrayList<T>();
    }
    //método para inserção de dados na fila (enfileiramento)
    public void enfil(T val) {
        this.data.add(val);
    }
    // método para remoção de dados da fila (dessenfileiramento)
    public T desenfil() {
        if(isEmpty()) return null;
        return this.data.remove(0);
    }
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
    //consultar o início da fila sem remover o elemento
    public T peak() {
        if (isEmpty()) return null;
        return this.data.get(0);
    }
    //método que imprime a fila para efeitos de repuração
    public String print() {
        StringBuilder output = new StringBuilder("[ ");
        for(int i = 0; i < this.data.size(); i++) {
            if(output.length() > 2) output.append(", ");
            output.append("(").append(i).append("): ").append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}