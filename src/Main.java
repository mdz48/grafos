import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        Grafo grafo = new Grafo();
        System.out.println("Indica la cantidad de vertices del grafo");
        cantidad = entrada.nextInt();
        while (cantidad < 2) {
            System.out.println("Ingrese una cantidad válida (Mayor a 1)");
            cantidad = entrada.nextInt();
        }
            for (int i = 1; i <= cantidad; i++) {
                grafo.agregarNodo(crearVertice(grafo));
            }
            grafo.agregarAristas();
            System.out.println(grafo);
    }

    public static Vertice crearVertice(Grafo grafo) {
        Scanner entrada = new Scanner(System.in);
        int val;
        boolean condicional = true;
        Vertice vertice = null;
        while (condicional) {
            System.out.println("Ingresa el valor del vertice (TIENE QUE SER MÚlTIPLO DE 13)");
            val = entrada.nextInt();
            if (val % 13 != 0) {
                System.out.println("Valor no es múltiple de 13");
            } else {
                boolean existe = false;
                for (int i = 0; i < grafo.getVertices().size(); i++) {
                    if (grafo.getVertices().get(i).getDato() == val) {
                        System.out.println("Este vertice ya existe, intente de nuevo");
                        existe = true;
                        i = grafo.getVertices().size();
                    }
                }
                if (!existe) {
                    vertice = new Vertice(val);
                    condicional = false;
                }
            }
        }
        return vertice;
    }
}