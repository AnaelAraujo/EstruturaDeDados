import java.util.Arrays;

public class DoubleLinkedList<T> {
    private static class Node<T> {
        public Node<T> prev, next;
        public T data;

        public Node(T val) {
            this.prev = null;
            this.data = val;
            this.next = null;
        }
    }
    private Node<T> head, tail;
    private int count;

    public DoubleLinkedList() {
        this.count = 0;
        this.tail = null;
        this.head = null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int getCount() {
        return this.count;
    }

    //metodo PRIVADO que encontra um nó por sua posição
    private Node<T> findNode(int pos) {
        Node<T> node;
        if(pos < this.count / 2) {
            node = this.head;
            for(int i = 0; i < pos; i++) {
                node = node.next;
            }
        } else {
            node = this.tail;
            for(int i = this.count - 1; i > pos; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public void insert(int pos, T val) {
        Node<T> inserted = new Node(val);

        //caso 1: lista vazia
        if(isEmpty()) {
            this.head = inserted;
            this.tail = inserted;
        }
        //caso 2: inserção na 1° posição
        else if(pos == 0) {
            inserted.next = this.head;
            this.head.prev = inserted;
            this.head = inserted;
        }
        //caso 3: inserção na úiltima posição
        else if(pos <= this.count) {
            inserted.prev = this.tail;
            this.tail.next = inserted;
            this.tail = inserted;
        }
        //caso 4: inserção em posição intermediária
        else {
            Node<T> nodePos = findNode(pos);
            Node<T> before = nodePos.prev;

            before.next = inserted;
            inserted.prev = before;
            inserted.next = nodePos;
            nodePos.prev = inserted;
        }

        this.count++;
    }
    //atalhos para inserção
    public void insertHead (T val) {
        this.insert(0, val);
    }
    public void insertTail(T val) {
        this.insert(this.count, val);
    }

    //metodo para remover um nodo de qualquer posição
    public T remove(int pos) {
        Node<T> removed;

        //caso 1: fora da lista ou sem lista
        if(isEmpty() || pos < 0 || pos > this.count - 1) {
            return null;
        }
        //caso 2: remoção do 1° nó
        else if(pos == 0) {
            removed = this.head;
            this.head = removed.next;

            if(this.head != null) {
                this.head.prev = null;
            }
            if(this.count == 1) {
                this.tail = null;
            }
        }

       //caso 3: remoção do último nó
        else if(pos == this.count - 1) {
            removed = this.tail;
            this.tail = removed.prev;

            if(this.tail != null) {
                this.tail.next = null;
            }
            if(this.count == 1) {
                this.head = null;
            }
        }

        //caso 4: remoção de um nodo intermediário
        else {
            removed = findNode(pos);
            Node<T> before = removed.prev;
            Node<T> after = removed.next;

            before.next = after;
            after.prev = before;
        }

        this.count--;
        return removed.data;
    }
    // atalhos para remoção
    public T removeHead() {
        return this.remove(0);
    }
    public T removeTail() {
        return this.remove(this.count - 1);
    }

    public T peak(int pos) {
        if(isEmpty() || pos < 0 || pos > this.count - 1) {
            return null;
        }
        Node<T> node = findNode(pos);
        return node.data;
    }

    public T peakHead() {
        return this.peak(0);
    }

    public T peakTail() {
        return this.peak(this.count - 1);
    }

    public int indexOf(T val) {
        int middle = (int) Math.ceil(this.count / 2);
        Node<T> node1 = this.head;
        Node<T> node2 = this.tail;

        for(int pos = 0; pos < middle; pos++) {
            if(val.equals(node1.data)) {
                return pos;
            }
            if(val.equals(node2.data)) {
                return this.count - 1 - pos;
            }
            node1 = node1.next;
            node2 = node2.prev;

        }
        return -1;
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

    public static void main(String[] args) {
        DoubleLinkedList<String> lista = new DoubleLinkedList();
        System.out.println("Lista vazia? " + lista.isEmpty());
        System.out.println(lista.print());

        lista.insert(0, "Fusca");
        System.out.println(lista.print());

        lista.insert(1, "QQ");
        System.out.println(lista.print());

        lista.insertHead("Corsa");
        System.out.println(lista.print());

        lista.insertTail("Porche");
        lista.insertTail("Carroça");
        System.out.println(lista.print());

        String removido = lista.remove(1);

        System.out.println("Removido 1: " + removido);
        System.out.println(lista.print());

        System.out.println("Posição 0: " + lista.peak(0));
        System.out.println("Posição 2: " + lista.peak(2));
        System.out.println("Posição 67: " + lista.peak(67));

        System.out.println("Posição do QQ: " + lista.indexOf("QQ"));

    }
}