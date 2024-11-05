package MochilaVoraz;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MochilaVoraz {
    public static void main(String[] args) {
        ArrayList<Objeto> lista = new ArrayList<>();
        lista.add(new Objeto(10,20));
        lista.add(new Objeto(20,30));
        lista.add(new Objeto(30,66));
        lista.add(new Objeto(40,40));
        lista.add(new Objeto(50,60));

        ArrayList<Objeto> container = new ArrayList<>();


        // Se esta modificando el objeto lista, asi que no es posible correr
        // las tres versiones sin antes hacer una copia de la lista de objetos.

        System.out.println( "-------------- Maximizando valor --------------"  );
        //TIP Ordena el arreglo según el valor, de mayor a menor
        lista.sort((o1, o2) -> Double.compare(o2.getValor(), o1.getValor()));
        imprimirContainer( agregarObjetos( 100, container, lista) );

    //    System.out.println( "-------------- Minimizando peso --------------"  );
    //    lista.sort((o1, o2) -> Double.compare(o1.getPeso(), o2.getPeso()));
    //    imprimirContainer( agregarObjetos( 100, container, lista) );

    //    System.out.println( "-------------- Por unidad de peso --------------"  );
    //    lista.sort((o1, o2) -> Double.compare(o2.getValorPorPeso(), o1.getValorPorPeso()));
    //    imprimirContainer( agregarObjetos( 100, container, lista) );

    }

    public static ArrayList<Objeto> agregarObjetos(int pesoMaximo, ArrayList<Objeto> container, ArrayList<Objeto> ListaObjetos) {
            for (Objeto o : ListaObjetos) {
                int pesoContainer = calcularPeso(container);
                for (double i = 0.9; i>0; i-=0.1) {
                    if ((o.getPeso() + pesoContainer) > pesoMaximo) {
                        o.setPorcentaje(i);
                    } else {
                        container.add(o);
                        break;
                    }
                }
        }
        return container;
    }

    public static int calcularPeso(ArrayList<Objeto> container) {
        int peso = 0;
        for (Objeto o: container) {
            peso += o.getPeso();
        }
        return peso;
    }

    public static void imprimirContainer(ArrayList<Objeto> container) {
        int peso = 0;
        int valor = 0;
        System.out.println("Objetos dentro del contenedor: ");
        for (Objeto o: container) {
            peso += o.getPeso();
            valor += o.getValor();
            System.out.println(o);
        }
        System.out.println("El peso del container es de " + peso + "\nEl valor del container es de " + valor);
    }

}

