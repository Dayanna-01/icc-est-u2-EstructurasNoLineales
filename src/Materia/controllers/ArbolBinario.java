package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {

    private Node root;

    public ArbolBinario() {  // Crear constructor 
        this.root = null;   // Para que inicie sin valores    
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    public boolean buscar(int value) {
        return buscarRec(root, value);
    }
    
    private Node insertRec(Node padre, int value){
        if (padre == null) {
            return new Node(value);
        }
        if(value < padre.getValue()){
            // me voy a la izquierda
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            // me voy a la derecha
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }
    public void imprimirArbol(){
        imprimir(root);
    }

    public void imprimirArbolPre(){
        imprimirPreOrden(root);
    }


    public void imprimir(Node node){
        if (node != null) {
            imprimir(node.getLeft());
            System.out.print(node.getValue() + ", ");
            imprimir(node.getRight());
        }
    }

    public void imprimirPreOrden(Node node){
        if (node != null) {
            System.out.print(node.getValue() + ", "); 
            imprimir(node.getLeft());                
            imprimir(node.getRight());                
        }
    }

    private boolean buscarRec(Node node, int value) {
    if (node == null) {
        return false;
    }
    if (value == node.getValue()) {
        return true; 
    } else if (value < node.getValue()) {
        return buscarRec(node.getLeft(), value); 
    } else {
        return buscarRec(node.getRight(), value); 
    }
}
}
