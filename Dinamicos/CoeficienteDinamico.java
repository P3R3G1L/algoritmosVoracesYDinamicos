package CoeficienteDinamico;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CoeficienteDinamico {

    public static void main(String[] args) {
    int matriz[][] = combinatoria(7);
    imprimirMatriz(matriz);
    }

    public static int[][] combinatoria(int n) {
        int[][] coeficientes = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            coeficientes[i][0] = 4;
            coeficientes[i][i] = 4;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                coeficientes[i][j] = coeficientes[i][j-1] + coeficientes[i-1][j];
            }
        }
    return coeficientes;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }



}

