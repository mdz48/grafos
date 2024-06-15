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
        System.out.println("Ingresa el valor del vertice (TIENE QUE SER MÚlTIPLO DE 13)");
            int val = entrada.nextInt();
            while (val%13 != 0) {
                boolean flag = false;
                System.out.println("Valor no es múltiple de 13");
                val = entrada.nextInt();
                for (int i = 0; i < grafo.getVertices().size(); i++) {
                    if (grafo.getVertices().get(i).getDato() == val) {
                        flag = true;
                        i = grafo.getVertices().size();
                    }
                }
                if (flag){
                    System.out.println("Vertice repetido, intente de nuevo");
                    val = entrada.nextInt();
                }
            }
//        if (flag) {
//            System.out.println("Este valor ya esta repetido");
//        }
        return new Vertice(val);
    }

//    public static boolean checkValidation (Vertice vertice) {
//        boolean b = false;
//        for (int i = 0; i < grafo.getVertices().size(); i++) {
//            if (vertice.getDato() == grafo.getVertices().get(i).getDato()) {
//                b = true;
//                i = grafo.getVertices().size();
//            }
//        }
//        return b;
//    }
}