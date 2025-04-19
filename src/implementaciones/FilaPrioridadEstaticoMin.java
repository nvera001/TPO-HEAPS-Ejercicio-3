package implementaciones;

import interfaces.FilaPrioridadTDA;

public class FilaPrioridadEstaticoMin implements FilaPrioridadTDA{

    class Elemento {
        int valor;
        int prioridad;
    }
    Elemento [] elementos;
    int cantidad;
    int capacidad = 15;

    private int padre(int indice) {
        return (indice - 1) / 2; //indice del heap padre. 
    }

    private int hijoIzq(int indice) {
        return 2 * indice + 1; //indice del hijo izq
    }

    private int hijoDer(int indice) {
        return 2 * indice + 2; //indice de hijo derecha
    }

    public void InicializarFila() {
        elementos = new Elemento[capacidad];
        cantidad = 0;
    }

    @Override
    public void Apilar(int x, int prior) {
        if (capacidad == cantidad){
            System.out.println("La fila llegó a su capacidad máxima de elementos.");
        } else {
            elementos [cantidad] = new Elemento();
            elementos [cantidad].valor = x;
            elementos[cantidad].prioridad = prior; 
            flotar(cantidad); //llama al metodo anterior, para ponerlo en su indice correcta.
            cantidad++;
        }
    }

    private void flotar(int i) {
        while (i > 0 && elementos[padre(i)].prioridad > elementos[i].prioridad) { //en caso de que el heap padre sea menor que el heap hijo.
            swap(padre(i), i); //los cambia en el metodo de arriba.
            i = padre(i); //busca la indice del padre en el metodo de arriba.
        }
    }
    private void swap(int i, int j) { //la i es el valor del indice padre, la j es el valor del indice hijo
        int temporal = elementos[i].prioridad; // guarda el valor del padre, para no sobreescribirlo.
        elementos[i].prioridad = elementos[j].prioridad; //el hijo pasa a ser padre.
        elementos[j].prioridad = temporal; //el padre pasa a ser hijo.
    }

    public int Primero() {
        return elementos[0].valor;
    }

    public int eliminar() {
        int eliminado = elementos[0].prioridad; //elimina el primer elemento de heap, en este caso el valor mas grande.
        elementos[0].prioridad = elementos[cantidad - 1].prioridad; //pone al ultimo elemento del heap, en primer lugar. 
        cantidad--; //disminuye la cantidad de elementos.
        hundir(0); //hunde el elemento que se puso en primer lugar, para reorganizar el heap en su conjunto.
        return eliminado; //devuelve el valor eliminado.
    }

    private void hundir(int i) { 
        int izquierdo = hijoIzq(i); //indice de hijo izq
        int derecho = hijoDer(i); //indice de hijo der
        int mayor = i; //indice de padre

        if (izquierdo < cantidad && elementos[izquierdo].prioridad < elementos[mayor].prioridad) {
            mayor = izquierdo;

        }
        if (derecho < cantidad && elementos[derecho].prioridad < elementos[mayor].prioridad) {
            mayor = derecho;

        }
        if (mayor != i) {
            swap(i, mayor); //los intercambia
            hundir(mayor); //los organiza
        }
    }

    public boolean FilaVacia() {
        return (cantidad == 0);
    }

    public int prioridad() {
        return elementos[0].prioridad;
    }

    public void mostrarComoArbol() {
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
    
            System.out.println(); // Salto de línea por nivel
        }
    }
    
    private void imprimirEspacios(int cantidadEspacios) {
        for (int i = 0; i < cantidadEspacios; i++) {
            System.out.print("       "); // doble espacio por mejor legibilidad
        }
    }
    
}
