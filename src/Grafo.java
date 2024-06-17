import java.util.*;

public class Grafo {
    private List<Vertice> listaVertices = new ArrayList<>();

    public void agregarNodo(Vertice verticeNuevo) {
        if (listaVertices == null) {
            listaVertices = new ArrayList<>();
            listaVertices.add(verticeNuevo);
        } else {
            listaVertices.add(verticeNuevo);
        }
    }

    public List<Vertice> getVertices() {
        return listaVertices;
    }

    public void agregarAristas() {
        int opcion = 0;
        Vertice destino, origen;
        int seleccionOrigen, seleccionDestino;
        Scanner entrada = new Scanner(System.in);
        do {
            for (int i = 0; i < listaVertices.size(); i++) {
                System.out.println((i + 1) + ") " + listaVertices.get(i).getDato());
            }
            System.out.println("Seleccione el numero del vertice origen");
            seleccionOrigen = entrada.nextInt();
            origen = listaVertices.get(seleccionOrigen - 1);
            System.out.println("Indique el numero del vertice destino");
            seleccionDestino = entrada.nextInt();
            destino = listaVertices.get(seleccionDestino - 1);
            System.out.println("Indique el peso");
            int peso = entrada.nextInt();
            if ( !existeArista(origen, destino)) {
                if (peso > 0) {
                    origen.getAristas().add(new Arista(origen, destino, peso));
                    System.out.println("Agregar mas aristas: 1)SI\t2)NO");
                    boolean condicional = true;
                    while (condicional) {
                        try {
                            opcion = entrada.nextInt();
                            if (opcion == 1 || opcion == 2) {
                                condicional = false;
                            } else {
                                System.out.println("Opción inválida. Por favor, ingrese 1 para sí o 2 para no.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: debe ingresar un número. Intente de nuevo.");
                            entrada.next(); 
                        }
                    }
                } else {
                    System.out.println("El peso debe ser positivo. Intente de nuevo.");
                    opcion = 1;
                }
            } else {
                System.out.println("Esta arista ya existe");
                opcion = 1;
            }

        } while (opcion == 1);
    }

    private boolean existeArista(Vertice origen, Vertice destino) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice vertice = listaVertices.get(i);
            List<Arista> aristas = vertice.getAristas();
            for (int j = 0; j < aristas.size(); j++) {
                Arista arista = aristas.get(j);
                if ((arista.getInicio().equals(origen) && arista.getFin().equals(destino))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void recorridoProfundidad(Vertice inicial) {
        List<Vertice> listaVisitados = new ArrayList<>();
        List<Vertice> pila = new ArrayList<>();

        pila.add(inicial);

        while (!pila.isEmpty()) {
            Vertice n = pila.remove(0);

            if (!listaVisitados.contains(n)) {
                listaVisitados.add(n);

                List<Arista> aristas = n.getAristas();
                List<Vertice> adyacentes = new ArrayList<>();
                for (int i = 0; i < aristas.size(); i++) {
                    adyacentes.add(aristas.get(i).getFin());
                }

                if (!adyacentes.isEmpty()) {
                    for (int i = 0; i < adyacentes.size(); i++) {
                        Vertice adyacente = adyacentes.get(i);
                        pila.add(0, adyacente);
                    }
                }
            }
        }

        // Desplegar la trayectoria, listaVisitados
        System.out.println("Recorrido de profundidad:");
        for (int i = 0; i < listaVisitados.size(); i++) {
            Vertice v = listaVisitados.get(i);
            System.out.print(v.getDato() + " ");
        }
    }


    @Override
    public String toString() {
        return "GRAFO [" + listaVertices + "\n]";
    }
}
