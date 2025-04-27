package implementaciones;

import interfaces.FilaPrioridadTDA;

public class FilaPrioridadEstaticoMin implements FilaPrioridadTDA{

    class Elemento {  //Se crea el elemento (nodo).
        int valor;
        int prioridad;
    }
    Elemento [] elementos; //Se asigna nodo a elementos.
    int cantidad;  //Asigna una cantidad
    int capacidad = 15; //Asigna capacidad de la fila.

    private int padre(int indice) {
        return (indice - 1) / 2; //Indice del heap padre. 
    }

    private int hijoIzq(int indice) {
        return 2 * indice + 1; //Indice del hijo izq
    }

    private int hijoDer(int indice) {
        return 2 * indice + 2; //Indice de hijo derecha
    }

    public void InicializarFila() { //Se inicializa la fila
        elementos = new Elemento[capacidad];
        cantidad = 0;
    }

    @Override
    public void Apilar(int x, int prior) { //Se agregan valores a la fila.
        if (capacidad == cantidad){  //En caso que la fila llegue a su capacidad maxima.
            System.out.println("La fila llegó a su capacidad máxima de elementos.");
        } else {
            elementos [cantidad] = new Elemento();  //Se crea un elemento.
            elementos [cantidad].valor = x; //Ingresa el valor del nuevo elemento.
            elementos[cantidad].prioridad = prior;  //Ingresa la prioridad
            flotar(cantidad); //Llama al metodo anterior, para ponerlo en su indice correcta.
            cantidad++; //Aumenta en uno la cantidad de la fila.
        } 
    }

    private void flotar(int i) {
        while (i > 0 && elementos[padre(i)].prioridad > elementos[i].prioridad) { //En caso de que el nodo padre sea menor que el nodo hijo.
            swap(padre(i), i); //Los cambia de posición.
            i = padre(i); //Pone la posición del padre.
        }
    }
    private void swap(int i, int j) { //La i es el valor de la posición padre, la j es el valor de la posición hijo
        int temporal = elementos[i].prioridad; // Guarda la prioridad del padre, para no sobreescribirlo.
        elementos[i].prioridad = elementos[j].prioridad; //La prioridad del hijo pasa a ser del padre.
        elementos[j].prioridad = temporal; //La prioridad del padre pasa a ser del hijo.
    }

    public int Primero() { //Retorna valor de la raiz.
        return elementos[0].valor;
    } 
    public int prioridad() { //Retorna prioridad de la raiz.
        return elementos[0].prioridad;
    }

    public int eliminar() {
        int eliminado = elementos[0].prioridad; //Guarda el primer elemento de la fila, en este caso la prioridad mas chica.
        elementos[0].prioridad = elementos[cantidad - 1].prioridad; //Pone al ultimo elemento de la fila, en primer lugar. 
        cantidad--; //Disminuye la cantidad de elementos.
        hundir(0); //Hunde el elemento que se puso en primer lugar, para reorganizar la fila en su conjunto.
        return eliminado; //Devuelve el valor eliminado.
    }

    private void hundir(int i) {  //Organizar la fila
        int izquierdo = hijoIzq(i); //Indice de hijo izq
        int derecho = hijoDer(i); //Indice de hijo der
        int mayor = i; //Indice de padre

        if (izquierdo < cantidad && elementos[izquierdo].prioridad < elementos[mayor].prioridad) {
            mayor = izquierdo;

        }
        if (derecho < cantidad && elementos[derecho].prioridad < elementos[mayor].prioridad) {
            mayor = derecho;

        }
        if (mayor != i) {
            swap(i, mayor); //Los intercambia
            hundir(mayor); //Los organiza
        }
    }

    public boolean FilaVacia() { //Devuelve true or false, si está o no vacía la fila.
        return (cantidad == 0);
    }

    public void mostrarComoArbol() { //Metodo que muestra claramente las funciones utilizadas.
        int niveles = (int) Math.floor(Math.log(cantidad) / Math.log(2)) + 1;
        int index = 0;
    
        for (int nivel = 0; nivel < niveles; nivel++) {
            int cantidadEnNivel = (int) Math.pow(2, nivel);
            int espacioAntes = (int) Math.pow(2, niveles - nivel - 1) - 1;
            int espacioEntre = (int) Math.pow(2, niveles - nivel) - 1;
    
            imprimirEspacios(espacioAntes);
    
            for (int i = 0; i < cantidadEnNivel && index < cantidad; i++) {
                Elemento e = elementos[index++];
                System.out.print(String.format("(x:%d, p:%d)", e.valor, e.prioridad));
                imprimirEspacios(espacioEntre);
            }
    
            System.out.println(); 
        }
    }
    
    private void imprimirEspacios(int cantidadEspacios) {
        for (int i = 0; i < cantidadEspacios; i++) {
            System.out.print("       "); 
        }
    }
    
}
