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

        /*
         * Enviar los subconjuntos al buzón externo.
         */
        for (int i = 0; i < subconjuntos.length; i++) {

            try {
                // Dormir el thread
                Thread.sleep(random.nextLong(50, 500));
            } catch (InterruptedException e) {
            }
            // Espera activa
            if (this.salidaBuzon.isFull())
                ProcesoInicio.yield();
            else
                salidaBuzon.almacenarProcesoInicial(subconjuntos[i]);

        }

        /*
         * Enviar los mensajes de FIN
         */
        for (int i = 0; i < 3; i++)
            if (this.salidaBuzon.isFull()) {
                i--;
                // Espera activa
                ProcesoInicio.yield();
            }

            else
                salidaBuzon.almacenarProcesoInicial("FIN");


    }


}
