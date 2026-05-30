import java.util.ArrayList;

public class Deque<T> {
    private ArrayList<T> data;

    public Deque() {
        this.data = new ArrayList<T>(); // lista vazia
    }

    //métodos para inserções de dados (início e fim)
    public void insertFront(T val) {
        this.data.add(0, val);
    }
    public void insertBack(T val) {
        this.data.add(val);
    }

    //método para informar se o deque está vazio ou não
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    //métodos de remoção de4 dados (início e fim)
    public T removeFront() {
        if(isEmpty()) return null;
        return this.data.remove(0);
    }
    public T removeBack() {
        if(isEmpty()) return null;
        return this.data.remove(this.data.size() - 1);
    }

    //Espiadinha na frente e atrás (sem braba)
    public T peakFront() {
        if(isEmpty()) return null;
        return this.data.get(0);
    }
    public T peakBack() {
        if(isEmpty()) return null;
        return this.data.get(this.data.size() - 1);
    }
    //método de impressão do deque para efeitos de depuração
    public String print() {
        StringBuilder output = new StringBuilder("[ ");
        for(int i = 0; i < this.data.size(); i++) {
            if(output.length() > 2) {
                output.append(", ");
            }
            output.append("(").append(i).append("): ").append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}
