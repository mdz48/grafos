public class Arista {
    private Vertice inicio;
    private Vertice fin;
    private int peso;

    public Arista(Vertice inicio, Vertice fin, int peso) {
        this.inicio = inicio;
        this.fin = fin;
        this.peso = peso;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFin() {
        return fin;
    }

    public void setFin(Vertice destino) {
        this.fin = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "["+inicio.getDato() + "-" + getPeso() + "-" + fin.getDato()+"]";
    }
}
