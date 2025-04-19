//Implemente en Java los métodos de las de prioridad utilizando esta 
//estructura y efectúe los cálculos de costos correspondientes.

package prin;

import implementaciones.FilaPrioridadEstaticoMax;
import interfaces.FilaPrioridadTDA;

public class prinEstaticoMax {
    public static void main(String[] args) {
        FilaPrioridadTDA elemento = new FilaPrioridadEstaticoMax();

        elemento.InicializarFila();
        System.out.println("La fila está vacía?  "+elemento.FilaVacia());
        elemento.Apilar(55, 10);
        elemento.Apilar(5566, 6);
        elemento.Apilar(532, 4);
        elemento.Apilar(554, 24);
        elemento.Apilar(5523, 1100);
        elemento.Apilar(5512, 423);
        elemento.Apilar(5555, 23);
        elemento.Apilar(5123, 442);
        elemento.Apilar(51, 123);
        elemento.Apilar(58, 1567);
        elemento.Apilar(5534, 1238);


        System.out.println("El elemento padre de esta fila es: " + elemento.prioridad()+" , el cual tiene un valor de: "+elemento.Primero());
        System.out.println(" ");
        System.out.println("Representación de la fila: ");
        elemento.mostrarComoArbol();
        System.out.println(" ");
        System.out.println("Se elimina el elemento padre: "+elemento.eliminar());
        System.out.println(" ");
        System.out.println("Después de la eliminación, la fila queda así: ");
        elemento.mostrarComoArbol();
    
    }   
}