package Materia.controllers;

import Materia.models.Node;
import java.util.ArrayList;

public class ArbolBinario {

    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) return new Node(value);
        if (value < padre.getValue()) padre.setLeft(insertRec(padre.getLeft(), value));
        else if (value > padre.getValue()) padre.setRight(insertRec(padre.getRight(), value));
        return padre;
    }

    public boolean buscar(int value) {
        boolean encontrado = buscarRec(root, value);
        System.out.println("Elemento " + value + (encontrado ? " encontrado" : " NO se encontró") + " en el árbol.");
        return encontrado;
    }

    private boolean buscarRec(Node node, int value) {
        if (node == null) return false;
        if (value == node.getValue()) return true;
        else if (value < node.getValue()) return buscarRec(node.getLeft(), value);
        else return buscarRec(node.getRight(), value);
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) return 0;
        return Math.max(getHeightRec(node.getLeft()), getHeightRec(node.getRight())) + 1;
    }

    public int getPeso() {
        return getPesoRec(root);
    }

    private int getPesoRec(Node node) {
        if (node == null) return 0;
        return 1 + getPesoRec(node.getLeft()) + getPesoRec(node.getRight());
    }

    public void inOrden() {
        inOrdenRec(root);
        System.out.println();
    }

    private void inOrdenRec(Node node) {
        if (node != null) {
            inOrdenRec(node.getLeft());
            System.out.print(node.getValue() + ", ");
            inOrdenRec(node.getRight());
        }
    }

    public void inOrdenConAlturas() {
        inOrdenConAlturasRec(root);
        System.out.println();
    }

    private void inOrdenConAlturasRec(Node node) {
        if (node != null) {
            inOrdenConAlturasRec(node.getLeft());
            int altura = getHeightRec(node);
            System.out.print(node.getValue() + "(h=" + altura + "), ");
            inOrdenConAlturasRec(node.getRight());
        }
    }

    public void inOrdenConBalance() {
        inOrdenConBalanceRec(root);
        System.out.println();
    }

    private void inOrdenConBalanceRec(Node node) {
        if (node != null) {
            inOrdenConBalanceRec(node.getLeft());
            int bf = getBalanceFactor(node);
            System.out.print(node.getValue() + "(bf=" + bf + "), ");
            inOrdenConBalanceRec(node.getRight());
        }
    }

    public int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
    }

    public boolean estaEquilibrado() {
        return estaEquilibradoRec(root);
    }

    private boolean estaEquilibradoRec(Node node) {
        if (node == null) return true;
        int bf = getBalanceFactor(node);
        if (Math.abs(bf) > 1) return false;
        return estaEquilibradoRec(node.getLeft()) && estaEquilibradoRec(node.getRight());
    }

    public void mostrarNodosDesequilibrados() {
        ArrayList<String> nodos = new ArrayList<>();
        obtenerNodosDesequilibrados(root, nodos);
        if (nodos.isEmpty()) {
            System.out.println("No hay nodos desequilibrados.");
        } else {
            System.out.print("Nodos desequilibrados: ");
            for (int i = 0; i < nodos.size(); i++) {
                System.out.print(nodos.get(i));
                if (i < nodos.size() - 1) System.out.print(" y ");
            }
            System.out.println();
        }
    }

    private void obtenerNodosDesequilibrados(Node node, ArrayList<String> nodos) {
        if (node != null) {
            int bf = getBalanceFactor(node);
            if (Math.abs(bf) > 1) {
                nodos.add(node.getValue() + "(fe = " + bf + ")");
            }
            obtenerNodosDesequilibrados(node.getLeft(), nodos);
            obtenerNodosDesequilibrados(node.getRight(), nodos);
        }
    }
}
