import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        /*
         * Ingreso del usuario
         */
        sc = new Scanner(System.in);

        System.out.println("Ingrese el mensaje inicial: ");
        String mensajeInicial = sc.nextLine();

        System.out.println("Ingrese el número de subconjuntos a generar (N donde N > 3):");
        int numSubconjuntos = sc.nextInt();

        System.out.println("Ingrese el tamaño de los buzones intermedios: ");

        int tamanioBuzonesIntermedios = sc.nextInt();

        System.out.println("Ingrese el tamaño de los buzones de los extremos: ");

        int tamanioBuzonesExtremos = sc.nextInt();

        sc.close();

        try {
            String[] arr = dividirMensaje(mensajeInicial, numSubconjuntos);
        } catch (Exception e) {
            System.out.println(
                    "El mensaje no puede ser dividido en " + numSubconjuntos + " subconjuntos");
        }



    }

    /**
     * Método para dividir el mensaje original en N subconjuntos de igual tamaño.
     * 
     * @param mensaje
     * @param numSubconjuntos
     * @return
     * @throws Exception
     */
    private static String[] dividirMensaje(String mensaje, int numSubconjuntos) throws Exception {
        String[] arr = new String[numSubconjuntos];

        if (mensaje.length() % numSubconjuntos != 0)
            throw new Exception("El tamaño del mensaje debe ser divisible por N");

        int tamanioSubconjunto = mensaje.length() / numSubconjuntos;

        int index = 0;

        for (int i = 0; i < mensaje.length(); i = i + tamanioSubconjunto) {
            arr[index] = mensaje.substring(i, i + tamanioSubconjunto);
            index++;
        }

        return arr;
    }

}
