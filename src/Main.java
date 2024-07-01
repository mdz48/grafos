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
        System.out.println("Ingrese el vértice de origen para hacer el recorrido de PROFUNDIDAD: ");
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            System.out.println((i + 1) + ") " + grafo.getVertices().get(i).getDato());
        }
        int seleccion = entrada.nextInt();
        Vertice inicial = grafo.getVertices().get(seleccion - 1);
        grafo.recorridoProfundidad(inicial);



        System.out.println("Ingrese el vertice que necesita el articulo");
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            System.out.println((i + 1) + ") " + grafo.getVertices().get(i).getDato());
        }
        seleccion = entrada.nextInt() - 1;
        Vertice cercano = grafo.searchStock(seleccion);
        if (cercano == null) {
            System.out.println("No existe articulos disponibles en ningun centro");
        } else {
            System.out.println("El centro mas cercano con disponibilidad es " + cercano.getDato());
        }





//                System.out.println("Ingrese el vértice de origen para el algoritmo de Dijkstra: ");
//        for (int i = 0; i < grafo.getVertices().size(); i++) {
//            System.out.println((i + 1) + ") " + grafo.getVertices().get(i).getDato());
//        }
//        seleccion = entrada.nextInt()-1;
//
//        CaminoMinimo caminoMinimo = new CaminoMinimo(grafo, seleccion);
//        caminoMinimo.Dijkstra(grafo, seleccion);
//        caminoMinimo.algoritmoDijkstra(grafo, seleccion);
    }

    public static Vertice crearVertice(Grafo grafo) {
        Scanner entrada = new Scanner(System.in);
        int val;
        boolean condicional = true;
        Vertice vertice = null;
        do  {
            try {
                System.out.println("Ingresa el valor del vertice (TIENE QUE SER MÚlTIPLO DE 13)");
                val = entrada.nextInt();
                System.out.println("Ingrese el stock del articulo");
                int stock = entrada.nextInt();

                if (val % 13 != 0) {
                    System.out.println("Valor no es múltiple de 13");
                } else if (stock < 0) {
                    System.out.println("Ingrese un stock mayor o igual a 0");
                } else {
                    boolean existe = false;
                    for (int i = 0; i < grafo.getVertices().size(); i++) {
                        if (grafo.getVertices().get(i).getDato() == val) {
                            System.out.println("Este vertice ya existe, intente de nuevo");
                            existe = true;
                            i = grafo.getVertices().size();
                        }
                    }
                    if (!existe ) {
                        vertice = new Vertice(val, stock);
                        condicional = false;
                    }
                }
            } catch (Exception e){
                System.out.println("Ingrese digitos");
                entrada.next();
                condicional = true;
            }

        } while (condicional);
        return vertice;
    }
}