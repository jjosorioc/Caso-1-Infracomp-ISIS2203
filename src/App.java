
import java.util.Scanner;
import buzon.Buzon;
import procesos.ProcesoFinal;
import procesos.ProcesoInicio;
import procesos.ProcesoIntermedio;

public class App {
    private static Scanner sc;

    /**
     * Matriz 3x2 con los buzones intermedios.
     */
    private static Buzon[][] buzonesIntermedio;

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

        /**
         * Arreglo de subconjuntos
         */
        String[] arr = crearSubconjuntos(numSubconjuntos);


        /*
         * Creación de los buzones de los extremos
         */

        Buzon buzonInicio = new Buzon(tamanioBuzonesExtremos);
        Buzon buzonFinal = new Buzon(tamanioBuzonesExtremos);


        /*
         * Creación de los buzones intermedios
         */
        crearBuzonesIntermedios(tamanioBuzonesIntermedios);



        /*
         * Crear procesos intermedios
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ProcesoIntermedio procesoIntermedio;
                if (j == 0) {
                    procesoIntermedio = new ProcesoIntermedio(buzonInicio, buzonesIntermedio[i][j],
                            i + 1, j + 1);
                } else if (j == 2) {
                    procesoIntermedio = new ProcesoIntermedio(buzonesIntermedio[i][j - 1],
                            buzonFinal, i + 1, j + 1);
                } else {
                    procesoIntermedio = new ProcesoIntermedio(buzonesIntermedio[i][j - 1],
                            buzonesIntermedio[i][j], i + 1, j + 1);
                }

                procesoIntermedio.start();

            }
        }

        /*
         * Crear Proceso Inicial y Final
         */
        ProcesoInicio procesoInicio = new ProcesoInicio(buzonInicio, arr);
        ProcesoFinal procesoFinal = new ProcesoFinal(buzonFinal);


        procesoInicio.start();
        procesoFinal.start();


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


    /**
     * Método para crear las instancias de los buzones.
     * 
     * @param tamanioBuzonesIntermedios
     */
    private static void crearBuzonesIntermedios(int tamanioBuzonesIntermedios) {

        buzonesIntermedio = new Buzon[3][2];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 2; j++)
                buzonesIntermedio[i][j] = new Buzon(tamanioBuzonesIntermedios);
    }

}
