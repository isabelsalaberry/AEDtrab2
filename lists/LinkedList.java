package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

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

    }

    @Override
    public boolean add(int i, E e) {
        return false;
    }

    @Override
    public E set(int i, E e) {
        return null;
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
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public E remove(int i) {
        return null;
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
