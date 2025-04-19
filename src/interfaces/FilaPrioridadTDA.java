package interfaces;

public interface FilaPrioridadTDA {
    void InicializarFila ();
    void Apilar (int x, int prioridad);
    int Primero ();
    int eliminar(); 
    boolean FilaVacia();
    int prioridad ();
    void mostrarComoArbol();
}
