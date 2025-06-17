package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {

    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    public boolean buscar(int value) {
        boolean encontrado = buscarRec(root, value);
        if (encontrado) {
            System.out.println("Elemento " + value + " encontrado en el árbol.");
        } else {
            System.out.println("Elemento " + value + " NO se encontró en el árbol.");
        }
        return encontrado;
    }
    
    private Node insertRec(Node padre, int value){
        if (padre == null) {
            return new Node(value);
        }
        if(value < padre.getValue()){
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimirArbol(){
        imprimir(root);
        System.out.println();
    }

    public void imprimirArbolPre(){
        imprimirPreOrden(root);
        System.out.println();
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
            imprimirPreOrden(node.getLeft());   
            imprimirPreOrden(node.getRight());  
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
