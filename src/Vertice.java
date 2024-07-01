import java.util .*;
public class Vertice {
    private int dato;
    private int stock;
    private List<Arista> listaAristas;

    public Vertice(int valor, int stock) {
        this.dato = valor;
        this.stock = stock;
        this.listaAristas = new ArrayList<>();
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int valor) {
        this.dato = valor;
    }

    public int getStock() {
        return stock;
    }



    public List<Arista> getAristas() {
        return listaAristas;
    }

    public void setAristas(Arista arista) {
        if (listaAristas == null) {
            listaAristas = new ArrayList<>();
        }
        listaAristas.add(arista);
    }

    @Override
    public String toString() {
        return "\n \t Vertice=" + getDato() + ", Stock= " +  stock  + ", Aristas=" + getAristas();
    }
}