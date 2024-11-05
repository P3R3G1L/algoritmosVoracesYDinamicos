import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase para representar una conexión entre dos municipios con un costo asociado.
class Conexion implements Comparable<Conexion> {
    int origen, destino, costo;

    public Conexion(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    // Compara las conexiones en base al costo, para ordenarlas en orden ascendente.
    @Override
    public int compareTo(Conexion otra) {
        return Integer.compare(this.costo, otra.costo);
    }
}

// Clase para representar el algoritmo de Union-Find.
class ConjuntoUnion {
    private int[] padre;
    private int[] rango;

    public ConjuntoUnion(int tamanio) {
        padre = new int[tamanio];
        rango = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            padre[i] = i;
            rango[i] = 0;
        }
    }

    // Encuentra el representante de un nodo con compresión de ruta.
    public int encontrar(int nodo) {
        if (padre[nodo] != nodo) {
            padre[nodo] = encontrar(padre[nodo]);
        }
        return padre[nodo];
    }

    // Une dos conjuntos.
    public boolean unir(int nodo1, int nodo2) {
        int raiz1 = encontrar(nodo1);
        int raiz2 = encontrar(nodo2);

        if (raiz1 != raiz2) {
            if (rango[raiz1] > rango[raiz2]) {
                padre[raiz2] = raiz1;
            } else if (rango[raiz1] < rango[raiz2]) {
                padre[raiz1] = raiz2;
            } else {
                padre[raiz2] = raiz1;
                rango[raiz1]++;
            }
            return true;
        }
        return false;
    }
}

public class RedFibraOptica {
    // Método para calcular el costo mínimo de conectar todos los municipios.
    public static int costoMinimo(int n, List<Conexion> conexiones) {
        // Ordena las conexiones por costo ascendente.
        Collections.sort(conexiones);
        ConjuntoUnion conjunto = new ConjuntoUnion(n);

        int costoTotal = 0;
        int conexionesUsadas = 0;

        // Recorre todas las conexiones y selecciona las de menor costo que no formen ciclos.
        for (Conexion conexion : conexiones) {
            if (conjunto.unir(conexion.origen, conexion.destino)) {
                costoTotal += conexion.costo;
                conexionesUsadas++;
                // Si ya tenemos n - 1 conexiones, hemos conectado todos los municipios.
                if (conexionesUsadas == n - 1) break;
            }
        }

        // Verifica si se usaron suficientes aristas para conectar todos los municipios.
        return conexionesUsadas == n - 1 ? costoTotal : -1; // -1 si no es posible conectar todos los municipios.
    }

    public static void main(String[] args) {
        int n = 4; // Número de municipios
        List<Conexion> conexiones = new ArrayList<>();

        // Agregar las conexiones posibles entre municipios
        conexiones.add(new Conexion(0, 1, 10000000));
        conexiones.add(new Conexion(0, 2, 6000000));
        conexiones.add(new Conexion(0, 3, 5000000));
        conexiones.add(new Conexion(1, 3, 15000000));
        conexiones.add(new Conexion(2, 3, 4000000));

        int costoMinimo = costoMinimo(n, conexiones);
        if (costoMinimo != -1) {
            System.out.println("El costo mínimo para conectar todos los municipios es: " + costoMinimo + " pesos");
        } else {
            System.out.println("No es posible conectar todos los municipios.");
        }
    }
}
