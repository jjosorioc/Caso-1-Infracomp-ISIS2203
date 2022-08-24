import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        /*
         * Ingreso del usuario
         */
        sc = new Scanner(System.in);

        System.out.println("Ingrese el número de subconjuntos a generar (N donde N > 3):");
        int numSubconjuntos = sc.nextInt();

        System.out.println("Ingrese el tamaño de los buzones intermedios: ");

        int tamanioBuzonesIntermedios = sc.nextInt();

        System.out.println("Ingrese el tamaño de los buzones de los extremos: ");

        int tamanioBuzonesExtremos = sc.nextInt();

        sc.close();


        String[] arr = crearSubconjuntos(numSubconjuntos);

    }

    /**
     * Método para generar los N subconjuntos
     * 
     * @param numSubconjuntos
     * @return Arreglo con N subconjuntos
     */
    private static String[] crearSubconjuntos(int numSubconjuntos) {
        String[] arr = new String[numSubconjuntos];
        String mensaje = "M";

        for (int i = 0; i < numSubconjuntos; i++)
            arr[i] = mensaje + (i + 1);

        return arr;
    }

}
