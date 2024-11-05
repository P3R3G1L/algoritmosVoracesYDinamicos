package DivideYVenceras;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DivideYVenceras {

    public static int sumaD(int arr[], int inicio, int fin) {
        if (inicio == fin) return arr[fin];

        int mitad = (inicio + fin)/2;

        int mitadizq = sumaD(arr, inicio, mitad);
        int mitadder = sumaD(arr, mitad+1, fin);

        return mitadizq + mitadder;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(sumaD(arr, 0, arr.length-1));
    }



}

