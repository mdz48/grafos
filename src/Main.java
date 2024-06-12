import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        Grafo grafo = new Grafo();
        System.out.println("Indica la cantidad de vertices del grafo");
        cantidad = entrada.nextInt();
        if (cantidad > 0) {
            for (int i = 1; i <= cantidad; i++) {
                grafo.agregarNodo(crearVertice());
            }
            grafo.agregarAristas();
            System.out.println(grafo);
        } else {
            System.out.println("Error, ingrese cantidad positva");
        }

    }

    public static Vertice crearVertice() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el valor del vertice");
        return new Vertice(entrada.nextInt());
    }
}