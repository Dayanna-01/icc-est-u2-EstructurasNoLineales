import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        System.out.println("Nombre: Dayanna Chacha");
        System.out.println();
        System.out.println("Peso del árbol = " + ab.getPeso());
        System.out.println("Altura es = " + ab.getHeight());
        System.out.println(

        );
        System.out.print("Arbol InOrden: ");
        ab.inOrden();

        System.out.print("\nArbol InOrder con alturas: \n");
        ab.inOrdenConAlturas();

        System.out.print("\nArbol InOrder con factor de equilibrio: \n");
        ab.inOrdenConBalance();

        System.out.println("\nArbol esta equilibrado : " + ab.estaEquilibrado());

        System.out.println("\nAgregamos valor : 15");
        ab.insert(15);

        System.out.println("\nArbol inOrden con factor de equilibrio:");
        ab.inOrdenConBalance();
        System.out.println();
        ab.mostrarNodosDesequilibrados();

    }
}
