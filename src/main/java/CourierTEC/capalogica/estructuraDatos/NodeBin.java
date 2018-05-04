/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourierTEC.capalogica.estructuraDatos;

/**
 *
 * @author Kenneth
 */
public class NodeBin<T> {
    private NodeBin<T> padre;
    private T element;
    private NodeBin<T> hDer;
    private NodeBin<T> hIzq;
    
    public NodeBin() {
        this.padre = null;
        this.element = null;
        this.hIzq = null;
        this.hDer = null;
    }
    
    public NodeBin(T element) {
        this.padre = null;
        this.element = element;
        this.hIzq = null;
        this.hDer = null;
    }
    
    public NodeBin(T element, NodeBin<T> padre) {
        this.padre = padre;
        this.element = element;
        this.hIzq = null;
        this.hDer = null;
    }
    
    public NodeBin(T element, NodeBin<T> padre, NodeBin<T> hIzq) {
        this.padre = padre;
        this.element = element;
        this.hIzq = hIzq;
        this.hDer = null;
    }
    
    public NodeBin(T element, NodeBin<T> padre, NodeBin<T> hIzq, NodeBin<T> hDer) {
        this.padre = padre;
        this.element = element;
        this.hIzq = hIzq;
        this.hDer = hDer;
    }

    public NodeBin<T> getPadre() {
        return padre;
    }

    public T getElement() {
        return element;
    }

    public NodeBin<T> gethDer() {
        return hDer;
    }

    public NodeBin<T> gethIzq() {
        return hIzq;
    }

    public void setPadre(NodeBin<T> padre) {
        this.padre = padre;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void sethDer(NodeBin<T> hDer) {
        this.hDer = hDer;
    }

    public void sethIzq(NodeBin<T> hIzq) {
        this.hIzq = hIzq;
    }
    
    public boolean isLeaf() {
        if (this.padre != null) {
            if (this.hDer == null && this.hIzq == null) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            System.out.println("Esta es la raiz");
            return false;
        }
    }
    
}
