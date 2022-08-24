package procesos;

import java.util.Random;
import buzon.Buzon;

public class ProcesoInicio extends Thread {
    /**
     * El buzón de salida es el buzón de entrada del proceso siguiente.
     */
    private Buzon salidaBuzon;


    /**
     * Arreglo con los subconjuntos de tamaño N.
     */
    private String[] subconjuntos;


    /**
     * Constructor del Proceso Inicial.
     * 
     * @param salidaBuzon
     * @param subconjuntos
     */
    public ProcesoInicio(Buzon salidaBuzon, String[] subconjuntos) {
        this.salidaBuzon = salidaBuzon;
        this.subconjuntos = subconjuntos;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < subconjuntos.length; i++) {

            try {
                Thread.sleep(random.nextLong(50, 500));
            } catch (InterruptedException e) {
            }
            salidaBuzon.almacenar(subconjuntos[i]);
        }

        for (int i = 0; i < 3; i++)
            salidaBuzon.almacenar("FIN");

        System.out.println("FIN PROCESO INICIAL");
    }


}
