package interfaces;

public interface FilaPrioridadTDA {
    void InicializarFila (); //Inicializar fila.
    void Apilar (int x, int prioridad); //Insertar valores en la fila, con su valor y prioridad.
    int Primero (); //Extrae raiz.
    int eliminar();  //Se elimina la raiz
    boolean FilaVacia(); //Fila está vacía?
    int prioridad (); //Se extrae prioridad de la raíz.
    void mostrarComoArbol(); //Muestra de la fila.
}
