package trab2.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends DoublyLinkedList<E> implements List<E> {

    protected class Node<E>{
        protected E data = null;
        protected Node<E> next = null;
        protected Node<E> previous = null;
        

        public Node (E d, Node<E> n, Node<E> p){
            this.data = d;
            this.next = n;
            this.previous = p;
        }

        public E getData (){
            return this.data;
        }

        public void setData (E e){
            this.data = e;
        }

        public Node<E> getNext () {
            return this.next;
        }

        public void setNext (Node<E> n) {
            this.next = n;
        }

        public Node<E> getPrevious () {
            return this.previous;
        }

        public void setPrevious (Node<E> p) {
            this.previous = p;
        }

    }

    protected Node<E> header;
    protected Node<E> trailer;
    protected int size;
  
    
    public LinkedList(){
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, null, header);
        this.header.setNext(this.trailer);
        this.size = 0;
    }
    
    
    
    public LinkedList(Node<E> header, Node<E> trailer, int size){
        this.header = header;
        this.trailer = trailer;
        this.size = size;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(E e) {
       if (isEmpty())
               addBetween(e, header,trailer);
       else
       addBetween(e,trailer.getPrevious(),trailer);
    }

    @Override
    public boolean add(int i, E e) {                        //algo não funciona e eu real nao sei dizer o que é
        if (i < 0 || i > size){
            return false;
        }
        Node<E> current = header.getNext();
        for (int j = 0; j <= i; j++) {
            current = current.getNext();

            if (j == i) {
                addBetween(e, current.getPrevious(), current);
                return true;

            }
        }
        return false;
    }

    protected void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrevious(newest);
        size++;
    }


    @Override
    public E set(int i, E e) {
        if (i < 0 || i > size)
            return null;
        else {

        Node<E> current = header.getNext();
        for (int j = 0; j <= i; j++) {
            current = current.getNext();

            if (j == i) {
                addBetween(e, current.getPrevious(), current.getNext());
            }
        }
        return e;
        }
    }


    @Override
    public void addAll(List<E> outra) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i > size)
            return null;
        else {

            Node<E> current = header.getNext();
            for (int j = 0; j <= i; j++) {
                current = current.getNext();
                if (j == i) {
                    return current.getData();                //duvida!!!! o getData() retorna o elemento apontado pelo it?
                }
            }
        }
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public E remove(int i) {
        E morto = null;

        if (i < 0 || i >= size)
            return null;
        else {
            Node<E> current = header;

            for (int j = 0; j <= i; j++) {
                current = current.getNext();

                if (j == i) {
                    morto = current.getData();

                    Node<E> predecessor = current.getPrevious();
                    Node<E> sucessor = current.getNext();

                    predecessor.setNext(sucessor);
                    sucessor.setPrevious(predecessor);

                    if (i == 0) {
                        // Se i for 0 header aopnta pro sucessor
                        header.setNext(sucessor);
                    }

                    size--;
                }
            }
        }
        return morto;
    }

    @Override
    public void clear() {

    }

    @Override
    public LinkedList<E> clone() {
        LinkedList<E> copy = new LinkedList<>(); //cria a lista

        Iterator<E> it = this.iterator();
        while (it.hasNext()){
            E data = it.next();
            copy.add(data); // copia os dados na ordem da lista atual
        }

        return null; // retorna a lista
    }

        
    //método pra teste na main
    public void print() {
        Node<E> current = header.getNext();
        int i=0;
        while((current!=null&&i<size())) {
            System.out.print(current.getData() + "\n");
            current = current.getNext();
            i++;
        }
        System.out.println();
    }
    
    
    
    
    @Override
    public Iterator<E> iterator() { return new LinkedList.DLLIterator(); }

    protected class DLLIterator implements Iterator<E>{
        protected Node<E> cursor = header;

        public boolean hasNext() {
            return cursor != trailer;
        }

        public E next(){
            if (cursor == trailer) throw new NoSuchElementException("Sem próximo elemento");
            Node<E> current = cursor;
            cursor=cursor.getNext();
            return current.getData();
        }
    }
    
    
    
}
