import java.util.*;

public class Grafo {
    private List<Vertice> listaVertices;

    public void agregarNodo(Vertice verticeNuevo) {
        if (listaVertices == null) {
            listaVertices = new ArrayList<>();
            listaVertices.add(verticeNuevo);
        } else {
            if (!listaVertices.contains(verticeNuevo)) {
                listaVertices.add(verticeNuevo);
            }
        }
    }

    public List<Vertice> getVertices() {
        return listaVertices;
    }

    public void agregarAristas() {
        int opcion;
        Vertice destino, origen;
        Scanner entrada = new Scanner(System.in);
        do {
            for (int i = 0; i < listaVertices.size(); i++) {
                System.out.println((i + 1) + ") " + listaVertices.get(i).getDato());
            }
            System.out.println("Seleccione el numero del vertice origen");
            opcion = entrada.nextInt();
            origen = listaVertices.get(opcion - 1);
            System.out.println("Indique el numero del vertice destino");
            opcion = entrada.nextInt();
            destino = listaVertices.get(opcion - 1);
            System.out.println("Indique el peso");
            int peso = entrada.nextInt();
            if (!(origen.equals(destino)) && !existeArista(origen, destino)) {
                if (peso > 0) {
                    origen.setAristas(new Arista(origen, destino, peso));
                    System.out.println("Agregar mas aristas: 1)SI\t2)NO");
                    opcion = entrada.nextInt();
                } else {
                    System.out.println("El peso debe ser positivo. Intente de nuevo.");
                }
            } else {
                System.out.println("El vertice de origen y el vertice destino son el mismo");
            }

        } while (opcion == 1);
    }

    private boolean existeArista(Vertice origen, Vertice destino) {
        for (int i = 0; i < listaVertices.size(); i++) {
            Vertice vertice = listaVertices.get(i);
            List<Arista> aristas = vertice.getAristas();
            for (int j = 0; j < aristas.size(); j++) {
                Arista arista = aristas.get(j);
                if ((arista.getInicio().equals(origen) && arista.getFin().equals(destino)) ||
                        (arista.getInicio().equals(destino) && arista.getFin().equals(origen))) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "GRAFO [" + listaVertices + "\n]";
    }
}
