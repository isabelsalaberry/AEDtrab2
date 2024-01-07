/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab2.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author isabel
 */

public class DoublyLinkedList<E> implements Iterable<E> {
    //------nasted node class-------
    protected static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element=e;
            prev=p;
            next=n;
        }
        public E getElement(){return element;}
        public void setElement(E element) {this.element = element;}
        public Node<E> getPrev(){return prev;}
        public Node<E> getNext(){return next;}
        public void setPrev(Node<E> p){prev=p;}
        public void setNext(Node<E> n){next=n;}
    }//-----end of nasted Node class-------

    
    protected Node<E> header;
    protected Node<E>trailer;
    private int size=0;
    //constructs a new empty list
    public DoublyLinkedList(){
        header=new Node<>(null, null, null);
        trailer=new Node<>(null, header,null);
        header.setNext(trailer);
    }
    //return the number of elements in the linked list
    public int size(){return size;}
    //tests whether the linked list is empty
    public boolean isEmpty(){return size==0;}
    //returns but does not remove the first element
    public E first(){return header.getNext().getElement();}
    //returns but does not remove the last element
    public E last(){return trailer.getPrev().getElement();}
    
    //public update methods
    
    //adds element e to the front of the list
    public void addFirst(E e){addBetween(e, header,header.getNext());}
    
    //adds element e to the end of the list
    public void addLast(E e){addBetween(e,trailer.getPrev(),trailer);}
    
    //removes and returns the first element of the list
    public E removeFirst(){
    if(isEmpty())return null;
    return remove(header.getNext());
    }
    
    //remove and returns the last element of the list
     public E removeLast(){
    if(isEmpty())return null;
    return remove(trailer.getPrev());
    }
    
     //private update methods
     
     //adds element e to the linked list in between the given nods
     protected void addBetween(E e, Node<E> predecessor, Node<E> successor){
         //create and link a new node
         Node<E>newest=new Node<>(e,predecessor,successor);
         predecessor.setNext(newest);
         successor.setPrev(newest);
         size++;
     }
    
     //removes the given node from the list and returns its element
     protected E remove(Node<E> node){
         Node<E> predecessor=node.getPrev();
         Node<E> successor=node.getNext();
         predecessor.setNext(successor);
         successor.setPrev(predecessor);
         size--;
         return node.getElement();
     }
     
     public Iterator<E> iterator(){
         return new DLLIterator();
     }
     
     private class DLLIterator implements Iterator<E>{
         private Node<E> cursor=header;
         
         public boolean hasNext(){
            return cursor!=trailer;  
         }
         
         public E next(){
             if(cursor==trailer)throw new NoSuchElementException("Sem proximo elemento");
             Node<E> current=cursor;
             cursor=cursor.getNext();
             return cursor.getElement();
         }
     }
     
}//-----end of DoublyLinkedList class-------
