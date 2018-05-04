/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourierTEC.capalogica.estructuraDatos;

/**
 *
 * @author Joel
 */
public class Node<T> {

    //atributos

    private T element;
    private Node<T> next;

    //Constructores
    public Node() {
        this.element = null;
        this.next = null;
    }

    public Node(T element) {
        this.element = element;
        this.next = null;
    }

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    //metodos

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
