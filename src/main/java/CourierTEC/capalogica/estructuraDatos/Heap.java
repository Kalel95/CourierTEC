/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourierTEC.capalogica.estructuraDatos;

/**
 *
 * @author Vaglio
 */
public class Heap<T>{
    private int weight; 

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    private T element;
    private Heap<T> father;
    private Heap<T> leftChild;
    private Heap<T> rightChild;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Heap<T> getFather() {
        return father;
    }

    public void setFather(Heap<T> father) {
        this.father = father;
    }

    public Heap<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Heap<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Heap<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Heap<T> rightChild) {
        this.rightChild = rightChild;
    }
    
    public Heap heap(T element){
        this.element = element;
        this.father = null;
        this.leftChild = null; 
        this.rightChild = null;
        
        return null;
    }
}
