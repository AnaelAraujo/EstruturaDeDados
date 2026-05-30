public class LinkedList<T> {
    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T val) {
            this.data = val;
            this.next = null;
        }
    }
    private Node<T> head; //início da lista
    private Node<T> tail; //fim da lista
    private int count; //quantidade de nós (nodos) da lista

    //método que retorna a quantidade de elementos da lista
    public int getCount() {
        return count;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    //método que retorna se a lista está vazia ou não
    public boolean isEmpty() {
        return this.count == 0;
    }

    //método para inserir em qualquer posição um nó na lista
    public void insert(int pos, T val) {
        //cria o nó para aramezar o valor pretendido
        Node<T> inserted = new Node(val);

        //1° caso: a lista está VAZIA
        if(isEmpty()) {
            this.head = inserted;
            this.tail = inserted;
        }
        //LISTA NÃO VAZIA
        //2° caso: inserção na primeira posição
        else if (pos == 0) {
            inserted.next = this.head;
            this.head = inserted;
        }
        //3° caso: inserção no final da lista
        else if (pos >= this.count) {
            this.tail.next = inserted;
            this.tail = inserted;
        }
        //4° caso: posição intermediária
        else {
            //aqui será descoberto a posição desejada
            Node<T> before = this.head;
            for(int i = 1; i < pos; i++) {
                before = before.next;
            }
            Node<T> after = before.next;

            //depois disso, será inserido
            inserted.next = after;
            before.next = inserted;
        }
        this.count++;
    }
    //atalhos para inserir na primeira e última posição
    public void insertHead(T val) {
        this.insert(0, val);
    }
    public void insertTail(T val) {
        this.insert(this.count, val);
    }

    public T remove(int pos) {

        //1° caso: a lista está VAZIA ou posição imformada está fora dos limites da lista
        if(isEmpty() || pos < 0 || pos > this.count - 1) {
            System.out.println("ERRO: não há nada na lista para remover ou a posição desejada não existe.");
            return null;
        }
        Node<T> removed;
        //LISTA NÃO VAZIA
        //2° caso: remoção do início da lista
        if(pos == 0) {
            removed = this.head;
            this.head = this.head.next;
            //atualizando o tail em caso de remoção do único nodo restante
            if(count == 1) this.tail = null;
        }
        //3° caso: remoção do nodo final ou intermediário da lista
        else {
            Node<T> before = this.head;
            for(int i = 1; i < pos; i++) {
                before = before.next;
            }
            removed = before.next;
            Node<T> after = removed.next;
            before.next = after;
            if(pos == this.count - 1) {
                this.tail = before;
            }
        }
        this.count--;
        return removed.data;
    }
    //atalhos para remoção das extremidades
    public T removeHead() {
        return remove(0);
    }
    public T removeTail() {
        return remove(this.count - 1);
    }

    //para ver a posição do valor desejado
    public int indextOf(T val) {
        //1° caso, lista vazia
        if(isEmpty())
            return -1;

        Node<T> node = this.head;
        for(int i = 0; i < this.count - 1; i++) {
            if(node.data.equals(val))
                return i;

            node = node.next;
        }
        return - 1;
    }

    //pra ver
    public T peak(int pos) {
        if(isEmpty() || pos < 0 || pos > this.count - 1) {
            System.out.println("ERRO: não há nada na lista para ver ou a posição desejada não existe.");
            return null;
        }

        Node<T> node = this.head;
        for(int i = 0; i < this.count - 1; i++) {
            node = node.next;
        }
        return node.data;
    }

    public T peakHead() {
        return this.peak(0);
    }
    public T peakTail() {
        return this.peak(this.count - 1);
    }

    public String print() {
        StringBuilder output = new StringBuilder("( ");
        Node<T> node = this.head;
        for(int i = 0; i < this.count; i++) {
            if(output.length() > 2) {
                output.append(", ");
            }
            output.append("[").append(i).append("]: ").append(node.data);
            node = node.next;
        }
        output.append(" ), count: ").append(this.count);
        return output.toString();
    }
    static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();

        lista.insert(0, "aaa");

        System.out.println(lista.print());
    }
}
