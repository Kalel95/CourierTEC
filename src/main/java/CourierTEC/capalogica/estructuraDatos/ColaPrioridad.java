/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda;

/**
 *
 * @author Joel
 */
public class ColaPrioridad <T>{
    LQueue[] ColaP; 
    
    public ColaPrioridad(int Tamaño){
        ColaP= new LQueue[Tamaño];
        int n=0;
        while(n<Tamaño){
          ColaP[n]=new LQueue();
          n++;
        }
    
    }
        public void enqueue(T element,int indice){
        ColaP[indice-1].enqueue(element);
        }
        
        /*
        public T dequeue(){
        if(this.size == 0){
            System.out.println("Queue is empty");
            return null;
        }
        T temp = this.front.getNext().getElement();
        Node<T> nTemp = this.front.getNext();
        this.front.setNext(nTemp.getNext());
        if (this.rear == nTemp){
            this.rear = this.front;
        }
        this.size--;
        return temp;
    }
*/
}
