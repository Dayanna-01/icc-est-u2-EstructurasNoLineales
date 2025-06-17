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

        System.out.print("Preorden: ");
        ab.imprimirArbolPre();
        System.out.print("Odenado: ");
        ab.imprimirArbol();
        System.out.println("____________________________________________");
        System.out.println("Encontrar Numeros:");
        System.out.println("Existe el numero 23: " + ab.buscar(23));
        System.out.println("Existe el numero 77: " + ab.buscar(77));
    }
}

